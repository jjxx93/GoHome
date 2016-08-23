package com.youtu.web;

import com.youtu.entity.Lost;
import com.youtu.service.LostService;
import com.youtu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by jiax on 2016/8/23.
 */
@Controller
@RequestMapping("")     //url：/模块/资源/{id}/细分    /seckill/list
public class YoutuController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LostService lostService;
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
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("user_id") String user_uuid, @RequestParam("password") String password) {
        if (userService.validation(user_uuid, password)) {
            return "getLostList";
        }
        return null;
    }
}
