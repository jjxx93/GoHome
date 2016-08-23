package com.youtu.web;

import com.youtu.entity.Lost;
import com.youtu.service.LostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/getLost",method = RequestMethod.GET)
    public String list(Model model){
//        获取列表页
        List<Lost> list = lostService.getLostList();
        model.addAttribute("list",list);
        //list.jsp + model = ModelAndView
        return "getLost";      //  /WEB-INF/jsp/"list".jsp
    }
}
