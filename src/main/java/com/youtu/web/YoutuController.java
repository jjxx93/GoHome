package com.youtu.web;

import com.youtu.entity.Lost;
import com.youtu.entity.User;
import com.youtu.service.LostService;
import com.youtu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiax on 2016/8/23.
 */
@Controller
@RequestMapping("")     //url：/模块/资源/{id}/细分    /seckill/list
public class YoutuController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HttpServletRequest request;

    @Autowired
    private LostService lostService;

    @Autowired
    private UserService userService;

    //获取列表页
    @RequestMapping(value = "/getLostList", method = RequestMethod.GET)
    public String getLostList(Model model) {
        List<Lost> list = lostService.getLostList();
        model.addAttribute("list", list);
        //list.jsp + model = ModelAndView
        return "getLostList";      //  /jsp/getLostList.jsp
    }

    //登录操作
    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> MLogin(User user, HttpSession session)  {
        Map<String, Object> jsonMap = new HashMap<String, Object>();

        if (user == null) {
            jsonMap.put("msg", "传输错误");
        } else {
            User rUser = userService.validation(user);
            if (rUser == null) {
                jsonMap.put("msg", "用户名或密码错误");
            } else {
                jsonMap.put("msg", "验证通过");
                jsonMap.put("user", rUser);
                session.setAttribute("user", rUser);
            }
        }

        return jsonMap;
    }
}
