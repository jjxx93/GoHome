package com.youtu.web;

import com.alibaba.fastjson.JSONObject;
import com.facepp.error.FaceppParseException;
import com.youtu.common.Constants;
import com.youtu.common.FaceppUtils;
import com.youtu.common.Msgs;
import com.youtu.dao.BefounderDao;
import com.youtu.entity.Befounder;
import com.youtu.entity.Face;
import com.youtu.entity.Matches;
import com.youtu.service.BefounderService;
import com.youtu.service.LosterService;
import com.youtu.service.MatchesService;
import com.youtu.service.UserService;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by jiax on 2016/10/2.
 */
@Controller
@RequestMapping("/volunteer")
public class VolunteerController {
    @Autowired
    private UserService userService;

    @Autowired
    private BefounderService befounderService;

    @Autowired
    private LosterService losterService;

    @Autowired
    private MatchesService matchesService;

//    @Autowired      //自动注入
//    private HttpResponse response;

    // 添加疑似走失者
    @RequestMapping(value = "/addBefounder", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addBefounder(String userUuid, String foundLocation, String foundTime, String picture,
                                            @RequestParam(value = "age", required = false, defaultValue = "0") int age,
                                            @RequestParam(value = "ageRange", required = false, defaultValue = "0") int ageRange,
                                            @RequestParam(value = "gender", required = false, defaultValue = "0") String gender,
                                            @RequestParam(value = "remarks", required = false, defaultValue = "0") String remarks) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {
            jsonObject = new JSONObject();

            System.out.println(age + ' ' + ageRange + ' ' + gender + ' ' + remarks);
            if (befounderService.addBefounder(userUuid, foundLocation, foundTime, picture, age, ageRange, gender,
                    remarks, "0")) {
                jsonObject.put("result", Constants.ADD_BEFOUNDER_SUCCESS);
                jsonObject.put("msg", Msgs.ADD_BEFOUNDER_SUCCESS);
            } else {
                jsonObject.put("result", Constants.ADD_BEFOUNDER_SUCCESS);
                jsonObject.put("msg", Msgs.ADD_BEFOUNDER_FAIL);
            }
        }
        return jsonObject;
    }

    // 查找本用户上传的疑似走失者
    @RequestMapping(value = "/getBefounders", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getBefounders(String userUuid) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {
            jsonObject = new JSONObject();

            List<Befounder> befounderList = befounderService.getBefounders(userUuid);    // 获取疑似走失者数据
            if (befounderList.isEmpty()) {        // 未获取到疑似走失者数据
                jsonObject.put("result", Constants.GET_BEFOUNDER_FAIL);
                jsonObject.put("msg", Msgs.GET_BEFOUNDER_FAIL);
                return jsonObject;
            }

            jsonObject.put("result", Constants.GET_BEFOUNDER_SUCCESS);
            jsonObject.put("msg", Msgs.GET_BEFOUNDER_SUCCESS);
            jsonObject.put("listLength", befounderList.size());
            jsonObject.put("list", befounderList);
        }

        return jsonObject;
    }

    // 查找疑似走失者
    @RequestMapping(value = "/getBefounder", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getBefounder(String userUuid, String uuid) {
        //response.setHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {
            jsonObject = new JSONObject();

            Befounder befounder = befounderService.getBefounder(uuid);    // 获取疑似走失者数据
            if (befounder == null) {        // 未获取到疑似走失者数据
                jsonObject.put("result", Constants.GET_BEFOUNDER_FAIL);
                jsonObject.put("msg", Msgs.GET_BEFOUNDER_FAIL);
                return jsonObject;
            }

            jsonObject.put("result", Constants.GET_BEFOUNDER_SUCCESS);
            jsonObject.put("msg", Msgs.GET_BEFOUNDER_SUCCESS);
            jsonObject.put("befounder", befounder);
        }

        return jsonObject;
    }

    // 修改疑似走失者信息
    @RequestMapping(value = "/modifyBefounder", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> modifyBefounder(String userUuid, String uuid, int age, int ageRange, String gender,
                                               String remarks) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {
            jsonObject = new JSONObject();

            Befounder befounder = befounderService.getBefounder(uuid); // 获得照片
            if (befounder == null) {           // 获取不到照片
                jsonObject.put("result", Constants.MODIFY_BEFOUNDER_NOPHOTO);
                jsonObject.put("msg", Msgs.MODIFY_BEFOUNDER_NOPHOTO);
                return jsonObject;
            }

            if (befounderService.modifyBefounder(uuid, age, ageRange, gender, remarks, "1")) {     // 修改成功
                jsonObject.put("result", Constants.MODIFY_BEFOUNDER_SUCCESS);
                jsonObject.put("msg", Msgs.MODIFY_BEFOUNDER_SUCCESS);
            } else {
                jsonObject.put("result", Constants.MODIFY_BEFOUNDER_FAIL);
                jsonObject.put("msg", Msgs.MODIFY_BEFOUNDER_FAIL);
            }
        }

        return jsonObject;
    }

    //分析疑似走失者信息
    @RequestMapping(value = "/detectBefounder", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> detectBefounder(String userUuid, String uuid) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {
            jsonObject = new JSONObject();

            Befounder befounder = befounderService.getBefounder(uuid); // 获得照片
            if (befounder == null) {           // 获取不到照片
                jsonObject.put("result", Constants.DETECT_BEFOUNDER_NOPHOTO);
                jsonObject.put("msg", Msgs.DETECT_BEFOUNDER_NOPHOTO);
                return jsonObject;
            }

            String picture = befounder.getPicture();

            try {
                Face face = FaceppUtils.detectUrl(picture);     // 分析查到的信息
                String gender = String.valueOf(face != null ? face.getGender() : 0);

                if (befounderService.modifyAgeAndGender(uuid, face != null ? face.getAge() : 0,
                        face != null ? face.getRange() : 0, gender, "2")) {
                    jsonObject.put("result", Constants.DETECT_BEFOUNDER_SUCCESS);
                    jsonObject.put("msg", Msgs.DETECT_BEFOUNDER_SUCCESS);
                    jsonObject.put("face", face);
                }
            } catch (FaceppParseException | JSONException e) {
                e.printStackTrace();
                jsonObject.put("result", Constants.DETECT_BEFOUNDER_FAIL);
                jsonObject.put("msg", Msgs.DETECT_BEFOUNDER_FAIL);
            }
        }

        return jsonObject;
    }

    //匹配疑似走失者信息
    @RequestMapping(value = "/matchBefounder", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> matchBefounder(String userUuid, String uuid) {
        // 检查用户uuid
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {   // 检查用户uuid通过
            jsonObject = new JSONObject();

            Befounder befounder = befounderService.getBefounder(uuid);   // 找出相关疑似者信息
            if (befounder == null) {            // 无相关疑似者信息
                jsonObject.put("result", Constants.MATCH_BEFOUNDER_NOPHOTO);
                jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_NOPHOTO);
                return jsonObject;
            } else if (befounder.getAge() == 0 && befounder.getAgeRange() == 0) {  // 相关疑似者未经过分析
                jsonObject.put("result", Constants.MATCH_BEFOUNDER_NODETECT);
                jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_NODETECT);
                return jsonObject;
            } else {
                // 在数据库中匹配相似脸
                return losterService.matchLosterByPictureAgeAndGender(befounder.getPicture(), losterService);
            }
        }

        return jsonObject;
    }

    //查找匹配表信息
    @RequestMapping(value = "/getMatch", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getMatch(String userUuid, String uuid) {
        // 检查用户uuid
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {   // 检查用户uuid通过
            jsonObject = new JSONObject();

            List<Matches> matchesList = matchesService.getMatchesList(userUuid, uuid);

            if (matchesList.isEmpty()) {  // 未找到相关信息
                jsonObject.put("result", Constants.GET_MATCHES_FAIL);
                jsonObject.put("msg", Msgs.GET_MATCHES_FAIL);
                return jsonObject;
            } else {
                jsonObject.put("result", Constants.GET_MATCCHES_SUCCESS);
                jsonObject.put("msg", Msgs.GET_MATCCHES_SUCCESS);
                jsonObject.put("length", matchesList.size());
                jsonObject.put("matchesList", matchesList);
            }
        }

        return jsonObject;
    }

    //查找匹配表信息
    @RequestMapping(value = "/match", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> match(String userUuid, String picture, String userType) {
        // 检查用户uuid
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {   // 检查用户uuid通过
            if (userType.equals("0")) {
                return losterService.matchLosterByPictureAgeAndGender(picture, losterService);
            } else {
                return befounderService.matchBefounderByPictureAgeAndGender(picture, befounderService);
            }
        }

        return jsonObject;
    }

    // 删除疑似走失者信息
    @RequestMapping(value = "/deleteBefounder", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteBefounder(String userUuid, String uuid) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);   // 检查用户uuid

        if (jsonObject == null) {   // 检查用户uuid通过
            jsonObject = new JSONObject();

            if (befounderService.deleteBefounderAndMatches(userUuid, uuid)) {          // 删除成功
                jsonObject.put("result", Constants.DELETE_BEFOUNDER_SUCCESS);
                jsonObject.put("msg", Msgs.DELETE_BEFOUNDER_SUCCESS);
                return jsonObject;
            } else {                                                        // 删除失败
                jsonObject.put("result", Constants.DELETE_BEFOUNDER_FAIL);
                jsonObject.put("msg", Msgs.DELETE_BEFOUNDER_FAIL);
            }
        }

        return jsonObject;
    }
}
