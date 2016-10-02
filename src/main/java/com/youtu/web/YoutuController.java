package com.youtu.web;

import com.alibaba.fastjson.JSONObject;
import com.youtu.common.Constants;
import com.youtu.common.Msgs;
import com.youtu.service.LosterService;
import com.youtu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by jiax on 2016/8/23.
 */
@Controller
@RequestMapping("")     //url：/模块/资源/{id}/细分    /seckill/list
public class YoutuController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    容器管理
    @Autowired
LosterService losterService;

    //获取列表页
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    //String 指定返回的视图页面名称，结合设置的返回地址路径加上页面名称后缀即可访问到
    public Map<String, Object> getLost() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "验证通过");
        return jsonObject;
    }
}
