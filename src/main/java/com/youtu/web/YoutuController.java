package com.youtu.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youtu.common.Constants;
import com.youtu.common.Msgs;
import com.youtu.entity.Loster;
import com.youtu.entity.User;
import com.youtu.service.LosterService;
import com.youtu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @Autowired
    UserService userService;

    //获取列表页
    @RequestMapping(value = "/losterList", method = RequestMethod.GET)
    @ResponseBody
    //String 指定返回的视图页面名称，结合设置的返回地址路径加上页面名称后缀即可访问到
    public Map<String, Object> getLosterList(@RequestParam(value = "updateTime", required = false) String updateTime,
                                             @RequestParam(value = "rows", required = false, defaultValue = "10") int rows) {
        JSONObject jsonObject = new JSONObject();
        List<Loster> losterList;

        if (updateTime == null) {           // 没有传入updateTime
            losterList = losterService.getLosterList(rows);
        } else {
            losterList = losterService.getLosterListByUpdateTime(updateTime, rows);
        }

        if (losterList.isEmpty()) {        // 未获取到消息
            jsonObject.put("result", Constants.GET_LOSTER_LIST_FAIL);
            jsonObject.put("msg", Msgs.GET_LOSTER_LIST_FAIL);
        } else {                           // 获取到了消息
            jsonObject.put("result", Constants.GET_LOSTER_LIST_SUCCESS);
            jsonObject.put("msg", Msgs.GET_LOSTER_LIST_SUCCESS);
            jsonObject.put("listLength", losterList.size());
            jsonObject.put("latestUpdateTime", losterList.get(0).getUpdateTime());

            JSONArray jsonArray = new JSONArray();
            for (Loster loster : losterList) {
                User user = userService.getUserByUserUuid(loster.getSourceId());
                JSONObject tempJsonObject = new JSONObject();
                tempJsonObject.put("losterUuid", loster.getLosterUuid());
                tempJsonObject.put("losterName", loster.getLosterName());
                tempJsonObject.put("age", loster.getAge());
                tempJsonObject.put("lostDate", loster.getLostDate());
                tempJsonObject.put("picture", loster.getPicture());
                tempJsonObject.put("remarks", loster.getRemarks());
                tempJsonObject.put("updateTime", loster.getUpdateTime());
                tempJsonObject.put("userName", user.getUserName());
                tempJsonObject.put("userHeadImg", user.getHeadImg());
                jsonArray.add(tempJsonObject);
            }

            jsonObject.put("list", jsonArray);
        }

        return jsonObject;
    }
}
