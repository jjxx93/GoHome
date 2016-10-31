package cn.gohome.web;

import cn.gohome.common.GetUUIDNumber;
import com.alibaba.fastjson.JSONObject;
import cn.gohome.common.Constants;
import cn.gohome.common.Msgs;
import cn.gohome.entity.Talks;
import cn.gohome.service.TalksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jiax on 2016/10/28.
 */
@Controller
@ResponseBody
@RequestMapping("/talks")
public class TalksController {
    @Autowired
    private TalksService talksService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> addTalk(Talks talks) {
        JSONObject jsonObject = new JSONObject();

        String uuid = GetUUIDNumber.createUUIDNumber();      // 获取TalkUuid
        talks.setUuid(uuid);                       // 设置TalkUuid

        SimpleDateFormat createTimeDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat updateTimeDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        talks.setCreateTime(createTimeDateFormat.format(new Date()));        // 设置CreateTime
        talks.setUpdateTime(updateTimeDateFormat.format(new Date()));        // 设置UpdateTime

        if (talksService.addTalks(talks)) {
            jsonObject.put("result", Constants.ADD_TALKS_SUCCESS);
            jsonObject.put("msg", Msgs.ADD_TALKS_SUCCESS);
            jsonObject.put("uuid", uuid);
        } else {
            jsonObject.put("result", Constants.ADD_TALKS_FAIL);
            jsonObject.put("msg", Msgs.ADD_TALKS_FAIL);
        }

        return jsonObject;
    }

    @RequestMapping(value = "/delete/{userUuid}/{uuid}", method = RequestMethod.POST)
    public Map<String, Object> deleteTalk(@PathVariable("userUuid") String userUuid, @PathVariable("uuid") String uuid) {
        JSONObject jsonObject = new JSONObject();

        if (talksService.deleteTalks(userUuid, uuid)) {
            jsonObject.put("result", Constants.DELETE_TALKS_SUCCESS);
            jsonObject.put("msg", Msgs.DELETE_TALKS_SUCCESS);
        } else {
            jsonObject.put("result", Constants.DELETE_TALKS_FAIL);
            jsonObject.put("msg", Msgs.DELETE_TALKS_FAIL);
        }

        return jsonObject;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Map<String, Object> modifyTalk(Talks talks) {
        JSONObject jsonObject = new JSONObject();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        talks.setUpdateTime(simpleDateFormat.format(new Date()));    // 设置CreateTime

        if (talksService.modifyTalks(talks)) {
            jsonObject.put("result", Constants.MODIFY_TALKS_SUCCESS);
            jsonObject.put("msg", Msgs.MODIFY_TALKS_SUCCESS);
        } else {
            jsonObject.put("result", Constants.MODIFY_TALKS_FAIL);
            jsonObject.put("msg", Msgs.MODIFY_TALKS_FAIL);
        }

        return jsonObject;
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public Map<String, Object> getTalk(@PathVariable("uuid") String uuid) {
        JSONObject jsonObject = new JSONObject();

        Talks talks = talksService.getTalksByUuid(uuid);  // 查询talks

        if (talks != null) {     // 获取到数据
            jsonObject.put("result", Constants.GET_TALKS_SUCCESS);
            jsonObject.put("msg", Msgs.GET_TALKS_SUCCESS);
            jsonObject.put("talk", talks);
        } else {
            jsonObject.put("result", Constants.GET_TALKS_FAIL);
            jsonObject.put("msg", Msgs.GET_TALKS_FAIL);
        }

        return jsonObject;
    }

    @RequestMapping(value = "/list/{userUuid}", method = RequestMethod.GET)
    public Map<String, Object> getTalkList(@PathVariable("userUuid") String userUuid) {
        JSONObject jsonObject = new JSONObject();

        List<Talks> talksList = talksService.getTalksByUserUuid(userUuid);  // 查询talks

        if (!talksList.isEmpty()) {     // 获取到数据
            jsonObject.put("result", Constants.GET_TALKS_SUCCESS);
            jsonObject.put("msg", Msgs.GET_TALKS_SUCCESS);
            jsonObject.put("listLength", talksList.size());
            jsonObject.put("talkList", talksList);
        } else {
            jsonObject.put("result", Constants.GET_TALKS_FAIL);
            jsonObject.put("msg", Msgs.GET_TALKS_FAIL);
        }

        return jsonObject;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> getTalks(@RequestParam(value = "updateTime", required = false) String updateTime,
                                        @RequestParam(value = "rows", required = false, defaultValue = "20") int rows) {
        JSONObject jsonObject = new JSONObject();

        List<Talks> talkList;
        if (updateTime != null) {           // 要查找最新消息
            talkList = talksService.getTalks(rows, updateTime);
        } else {
            talkList = talksService.getTalks(rows);
        }

        if (talkList.isEmpty()) {        // 未获取到消息
            jsonObject.put("result", Constants.GET_TALKS_FAIL);
            jsonObject.put("msg", Msgs.GET_TALKS_FAIL);
        } else {                           // 获取到消息
            jsonObject.put("result", Constants.GET_TALKS_SUCCESS);
            jsonObject.put("msg", Msgs.GET_TALKS_SUCCESS);

            jsonObject.put("listLength", talkList.size());
            jsonObject.put("talkList", talkList);
        }

        return jsonObject;
    }
}
