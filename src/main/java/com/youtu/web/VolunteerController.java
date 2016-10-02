package com.youtu.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
import com.youtu.common.Constants;
import com.youtu.common.FaceppUtils;
import com.youtu.common.Msgs;
import com.youtu.dao.BefounderDao;
import com.youtu.entity.Befounder;
import com.youtu.entity.Face;
import com.youtu.entity.Loster;
import com.youtu.entity.Matches;
import com.youtu.service.BefounderService;
import com.youtu.service.LosterService;
import com.youtu.service.MatchesService;
import com.youtu.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by jiax on 2016/10/2.
 */
@Controller
@RequestMapping("/volunteer")
public class VolunteerController {
    @Autowired      //自动注入
    private BefounderDao befounderDao;

    @Autowired
    private UserService userService;

    @Autowired
    private BefounderService befounderService;

    @Autowired
    private LosterService losterService;

    @Autowired
    private MatchesService matchesService;

    // 添加疑似走失者
    @RequestMapping(value = "/addBefounder", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addBefounder(String userUuid, String foundLocation, String foundTime, String picture) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {
            jsonObject = new JSONObject();
            if (befounderService.addBefounder(userUuid, foundLocation, foundTime, picture, "0")) {
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
    @RequestMapping(value = "/getBefounder", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getBefounder(String userUuid) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {
            jsonObject = new JSONObject();

            List<Befounder> befounderList = befounderService.getBefounder(userUuid);    // 获取疑似走失者数据
            if (befounderList.isEmpty()) {        // 未获取到疑似走失者数据
                jsonObject.put("result", Constants.GET_BEFOUNDER_FAIL);
                jsonObject.put("msg", Msgs.GET_BEFOUNDER_FAIL);
                return jsonObject;
            }

            jsonObject.put("result", Constants.GET_BEFOUNDER_SUCCESS);
            jsonObject.put("msg", Msgs.GET_BEFOUNDER_SUCCESS);
            jsonObject.put("list", befounderList);
        }

        return jsonObject;
    }

    // 修改疑似走失者信息
    @RequestMapping(value = "/modifyBefounder", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> modifyBefounder(String userUuid, String uuid, int age, int ageRange, String gender) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {
            jsonObject = new JSONObject();

            String picture = befounderDao.queryByUuidAndFounderUuid(uuid, userUuid).getPicture(); // 获得照片
            if (picture == null) {           // 获取不到照片
                jsonObject.put("result", Constants.MODIFY_BEFOUNDER_NOPHOTO);
                jsonObject.put("msg", Msgs.MODIFY_BEFOUNDER_NOPHOTO);
                return jsonObject;
            }

            String genderInt = "0";
            if (gender.equals("女")) {
                genderInt = "1";
            }

            if (befounderDao.uploadAgeAndGender(uuid, age, ageRange, genderInt, "1") > 0) {     // 修改成功
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

            Befounder befounder = befounderDao.queryByUuidAndFounderUuid(uuid, userUuid); // 获得照片
            if (befounder == null) {           // 获取不到照片
                jsonObject.put("result", Constants.DETECT_BEFOUNDER_NOPHOTO);
                jsonObject.put("msg", Msgs.DETECT_BEFOUNDER_NOPHOTO);
                return jsonObject;
            }

            String picture = befounder.getPicture();

            try {
                Face face = FaceppUtils.detectUrl(picture);     // 分析查到的信息
                String gender = String.valueOf(face.getGender());

                if (befounderDao.uploadAgeAndGender(uuid, face.getAge(), face.getRange(), gender, "2") > 0) {
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

            Befounder befounder = befounderDao.queryByUuidAndFounderUuid(uuid, userUuid);   // 找出相关疑似者信息
            if (befounder == null) {            // 无相关疑似者信息
                jsonObject.put("result", Constants.MATCH_BEFOUNDER_NOPHOTO);
                jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_NOPHOTO);
                return jsonObject;
            } else if (befounder.getAge() == 0 && befounder.getRange() == 0) {  // 相关疑似者未经过分析
                jsonObject.put("result", Constants.MATCH_BEFOUNDER_NODETECT);
                jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_NODETECT);
                return jsonObject;
            } else {
                List<Loster> losterList = losterService.matchLosterByAgeAndGender(befounder.getAge(), befounder.getRange(), befounder.getGender());
                System.out.println(losterList);

                if (losterList.isEmpty()) {       // 数据库中无匹配信息
                    jsonObject.put("result", Constants.MATCH_BEFOUNDER_NOLOSTER);
                    jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_NOLOSTER);
                    return jsonObject;
                } else {
                    try {
                        Face face1 = FaceppUtils.detectUrl(befounder.getPicture());

                        // 循环检测相关图片相似度
                        JSONArray jsonArray = new JSONArray();
                        for (Loster loster : losterList) {
                            Face face2 = FaceppUtils.detectUrl(loster.getPicture());
                            if (face2 == null) continue;
                            HttpRequests httpRequests = new HttpRequests(Constants.API_Key, Constants.API_Secret, true, true);

                            PostParameters postParameters = new PostParameters().setFaceId1(face1.getFaceId());
                            postParameters.setFaceId2(face2.getFaceId());

                            int similarity = httpRequests.recognitionCompare(postParameters).getInt("similarity");

                            if (similarity > 50) {          // 只取相似度大于50的值
                                // 添加数据到json对象
                                face2.setLosterUuid(loster.getLosterUuid());
                                face2.setFaceUrl(loster.getPicture());
                                face2.setSimilarity(similarity);
                                jsonArray.add(face2);

                                // 添加数据到match表
                                matchesService.addMatches(userUuid, uuid, loster.getLosterUuid(), similarity, "0");
                            }
                        }

                        if (jsonArray == null) {    // 数据库中无相似度大于50的匹配信息
                            jsonObject.put("result", Constants.MATCH_BEFOUNDER_NOLOSTER);
                            jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_NOLOSTER);
                            return jsonObject;
                        } else {
                            jsonObject.put("result", Constants.MATCH_BEFOUNDER_SUCCESS);
                            jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_SUCCESS);
                            jsonObject.put("ListLength", jsonArray.size());
                            jsonObject.put("SourceFace", face1);
                            jsonObject.put("faceArray", jsonArray);
                            return jsonObject;
                        }
                    } catch (JSONException | FaceppParseException e) {
                        e.printStackTrace();
                        jsonObject.put("result", Constants.MATCH_BEFOUNDER_FAIL);
                        jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_FAIL);
                        return jsonObject;
                    }
                }
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
}
