package com.youtu.web;

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
import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
    public Map<String, Object> login(String userName, String password, HttpSession session)  {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        //获取正确验证码
        //String validateCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);

        //if (user.getValidateCode().toUpperCase().equals(validateCode)) {
        User rUser = userService.validation(userName, password);

        if (rUser == null) {
            jsonMap.put("result", "用户名或密码错误");
        } else {
            jsonMap.put("result", "验证通过");
            jsonMap.put("username", rUser.getUserName());
            jsonMap.put("password", rUser.getPassword());
            jsonMap.put("userUuid", rUser.getUserUuid());
            //session.setAttribute("user", rUser);
        }
//        } else {
//            jsonMap.put("msg", "验证码错误");
//        }

        return jsonMap;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> register(String userName, String password, HttpSession session)  {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        // 邮箱是否已注册
        //if (userService.isEmailExisted(user.getEmail())) {
        //    jsonMap.put("result", spwConstants.REGISTE_EMAIL_EXIST);
        //} else
        //if (userService.isUsernameExisted(user.getUsername())) {
        //    jsonMap.put("result", spwConstants.REGISTE_USERNAME_EXIST); // 账号是否已注册
        //} else {
        //    if (user.getUsername() == null) {
        //        user.setUsername(user.getEmail());
        //    }
            User rUser = userService.addUserNameAndPassword(userName, password);
            if (rUser != null) {
                jsonMap.put("username", rUser.getUserName());
                jsonMap.put("password", rUser.getPassword());
                jsonMap.put("userUuid", rUser.getUserUuid());
                jsonMap.put("result", "注册成功");
            } else {
                jsonMap.put("result", "注册失败");
            }
        //}

        return jsonMap;
    }
}
