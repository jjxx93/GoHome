package cn.gohome.web;

import cn.gohome.common.Constants;
import cn.gohome.entity.Loster;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import cn.gohome.service.LosterService;
import cn.gohome.common.Msgs;
import cn.gohome.service.UserService;
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
@RequestMapping("/relative")
public class RelativeController {
    @Autowired
    UserService userService;

    @Autowired
    LosterService losterService;

    @RequestMapping(value = "/getLosters", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getLosters(String userUuid) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {
            jsonObject = new JSONObject();

            List<Loster> losters = losterService.getLosterByUserUuid(userUuid);     // 获取走失者数据

            if (losters.isEmpty()) {    // 未获取到数据
                jsonObject.put("result", Constants.GET_LOSTER_FAIL);
                jsonObject.put("msg", Msgs.GET_LOSTER_FAIL);
                return jsonObject;
            } else {                    // 获取到走失者数据
                jsonObject.put("result", Constants.GET_LOSTER_SUCCESS);
                jsonObject.put("msg", Msgs.GET_LOSTER_SUCCESS);

                JSONArray jsonArray = new JSONArray();  // List转换成数组
                for (Loster loster : losters) {
                    JSONObject tempJsonObject = new JSONObject();
                    tempJsonObject.put("losterUuid", loster.getLosterUuid());
                    tempJsonObject.put("losterName", loster.getLosterName());
                    tempJsonObject.put("picture", loster.getPicture());
                    tempJsonObject.put("remarks", loster.getRemarks());
                    jsonArray.add(tempJsonObject);
                }

                jsonObject.put("arrayLength", jsonArray.size());
                jsonObject.put("losterArray", jsonArray);
            }
        }

        return jsonObject;
    }

    // 新增丢失者信息
    @RequestMapping(value = "/addLoster", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addLoster(String userUuid, String losterName, String losterBirthday, String gender, String height,
                                         String lostDate, String picture, String lostLocation, String remarks) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {
            jsonObject = new JSONObject();
            int heightInt = Integer.parseInt(height);

            if (losterService.addLoster(userUuid, losterName, losterBirthday, gender, heightInt, lostDate,
                    picture, lostLocation, remarks)) {
                jsonObject.put("result", Constants.ADD_LOSTER_SUCCESS);
                jsonObject.put("msg", Msgs.ADD_LOSTER_SUCCESS);
            } else {
                jsonObject.put("result", Constants.ADD_LOSTER_FAIL);
                jsonObject.put("msg", Msgs.ADD_LOSTER_FAIL);
            }
        }

        return jsonObject;
    }

    @RequestMapping(value = "/getLoster", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getLoster(String userUuid, String losterUuid) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {
            jsonObject = new JSONObject();

            Loster loster = losterService.getLosterByLosterUuid(losterUuid);    // 获取走失者数据

            if (loster == null) {    // 未获取到数据
                jsonObject.put("result", Constants.GET_LOSTER_FAIL);
                jsonObject.put("msg", Msgs.GET_LOSTER_FAIL);
                return jsonObject;
            } else {                    // 获取到走失者数据
                jsonObject.put("result", Constants.GET_LOSTER_SUCCESS);
                jsonObject.put("msg", Msgs.GET_LOSTER_SUCCESS);

                jsonObject.put("loster", loster);
            }
        }

        return jsonObject;
    }

    // 新增丢失者信息
    @RequestMapping(value = "/modifyLoster", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> modifyLoster(String userUuid, String losterUuid, String losterName, String losterBirthday, String gender,
                                            String height, String lostDate, String picture, String lostLocation, String remarks) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {
            jsonObject = new JSONObject();
            int heightInt = Integer.parseInt(height);

            if (losterService.modifyLosterByLosterUuid(userUuid, losterUuid, losterName, losterBirthday, gender,
                    heightInt, lostDate, picture, lostLocation, remarks)) {
                jsonObject.put("result", Constants.MODIFY_LOSTER_SUCCESS);
                jsonObject.put("msg", Msgs.MODIFY_LOSTER_SUCCESS);
            } else {
                jsonObject.put("result", Constants.MODIFY_LOSTER_FAIL);
                jsonObject.put("msg", Msgs.MODIFY_LOSTER_FAIL);
            }
        }

        return jsonObject;
    }

    // 新增丢失者信息
    @RequestMapping(value = "/deleteLoster", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteLoster(String userUuid, String losterUuid) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {
            jsonObject = new JSONObject();

            if (losterService.deleteLoster(userUuid, losterUuid)) {
                jsonObject.put("result", Constants.DELETE_LOSTER_SUCCESS);
                jsonObject.put("msg", Msgs.DELETE_LOSTER_SUCCESS);
            } else {
                jsonObject.put("result", Constants.DELETE_LOSTER_FAIL);
                jsonObject.put("msg", Msgs.DELETE_LOSTER_FAIL);
            }
        }

        return jsonObject;
    }
}
