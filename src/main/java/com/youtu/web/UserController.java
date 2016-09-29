package com.youtu.web;

import com.alibaba.fastjson.JSONObject;
import com.youtu.common.Constants;
import com.youtu.common.Msgs;
import com.youtu.entity.User;
import com.youtu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by jiax on 2016/9/19.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //容器管理
    @Autowired
    HttpServletRequest request;

    @Autowired
    private UserService userService;

    //登录操作
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody   //直接将返回值输出到页面
    public Map<String, Object> login(String userName, String password)  {
        JSONObject jsonObject = new JSONObject();
        User rUser = userService.validation(userName, password);

        if (rUser == null) {
            jsonObject.put("result", Constants.LOGIN_PASSWORD_ERROR);
            jsonObject.put("msg", Msgs.LOGIN_PASSWORD_ERROR);
        } else {
            jsonObject.put("result", Constants.LOGIN_SUCCESS);
            jsonObject.put("msg", Msgs.LOGIN_SUCCESS);
            jsonObject.put("userName", rUser.getUserName());
            jsonObject.put("password", rUser.getPassword());
            jsonObject.put("userUuid", rUser.getUserUuid());
            jsonObject.put("userStatus", userService.validationUserUuid(rUser.getUserUuid()));
        }

        return jsonObject;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> register(String userName, String password) {
        JSONObject jsonObject = new JSONObject();

        if (userService.isUserNameExisted(userName)) {
            jsonObject.put("result", Constants.REGISTE_USERNAME_EXIST); // 账号是否已注册
            jsonObject.put("msg", Msgs.REGISTE_USERNAME_EXIST);
        } else {
            User rUser = userService.addUser(userName, password);
            if (rUser != null) {
                jsonObject.put("userName", rUser.getUserName());
                jsonObject.put("password", rUser.getPassword());
                jsonObject.put("userUuid", rUser.getUserUuid());
                jsonObject.put("result", Constants.REGISTE_SUCCESS);
                jsonObject.put("msg", Msgs.REGISTE_SUCCESS);
            } else {
                jsonObject.put("result", Constants.REGISTE_FAILURE);
                jsonObject.put("msg", Msgs.REGISTE_FAILURE);
            }
        }

        return jsonObject;
    }

    @RequestMapping(value = "/changeHeadImg", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> changeHeadImg(String userUuid, String headImg) {
        JSONObject jsonObject = new JSONObject();

        int userState = userService.validationUserUuid(userUuid);

        if (userState == 1) {
            jsonObject.put("result", Constants.USER_DISABLE);
            jsonObject.put("msg", Msgs.USER_DISABLE);
            return jsonObject;
        } else if (userState == 2) {
            jsonObject.put("result", Constants.USER_NOT_EXIST);
            jsonObject.put("msg", Msgs.USER_NOT_EXIST);
            return jsonObject;
        }

        if (userService.changeHeadImg(userUuid, headImg)) {
            jsonObject.put("result", Constants.CHANGE_HEAD_IMG_SUCCESS);
            jsonObject.put("msg", Msgs.CHANGE_HEAD_IMG_SUCCESS);
        } else {
            jsonObject.put("result", Constants.CHANGE_HEAD_IMG_FAILURE);
            jsonObject.put("msg", Msgs.CHANGE_HEAD_IMG_FAILURE);
        }

        return jsonObject;
    }
}
