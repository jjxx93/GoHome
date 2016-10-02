package com.youtu.web;

import com.alibaba.fastjson.JSONObject;
import com.youtu.common.Constants;
import com.youtu.common.Msgs;
import com.youtu.service.LosterService;
import com.youtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    // 新增丢失者信息
    @RequestMapping(value = "/addLoster", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addLoster(String userUuid, String losterName, String losterBirthday, String gender, String height,
                                         String lostDate, String picture, String lostLocation, String characteristic) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {
            jsonObject = new JSONObject();
            int heightInt = Integer.valueOf(height);
            if (losterService.addLoster(losterName, losterBirthday, gender, heightInt, lostDate,
                    picture, lostLocation, characteristic)) {
                jsonObject.put("result", Constants.ADD_LOSTER_SUCCESS);
                jsonObject.put("msg", Msgs.ADD_LOSTER_SUCCESS);
            } else {
                jsonObject.put("result", Constants.ADD_LOSTER_FAIL);
                jsonObject.put("msg", Msgs.ADD_LOSTER_FAIL);
            }
        }

        return jsonObject;
    }
}
