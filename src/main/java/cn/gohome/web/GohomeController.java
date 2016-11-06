package cn.gohome.web;

import cn.gohome.common.Constants;
import cn.gohome.common.Msgs;
import cn.gohome.entity.Loster;
import cn.gohome.entity.User;
import cn.gohome.service.CommonService;
import cn.gohome.service.LosterService;
import cn.gohome.service.UserService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
public class GohomeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 容器管理
    @Autowired
    CommonService commonService;

    /**
     * 返回首页数据
     * @param latestTime
     * @param earliestTime
     * @param rows
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getLosterList(@RequestParam(value = "latestTime", required = false) String latestTime,
                                             @RequestParam(value = "earliestTime", required = false) String earliestTime,
                                             @RequestParam(value = "rows", required = false, defaultValue = "10") int rows) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray;

        if (latestTime != null) {           // 要查找latestTime时间之后的消息
            jsonArray = commonService.getList(latestTime, rows);
        } else if (earliestTime != null) {  // 要查找earliestTime时间之前的消息
            jsonArray = commonService.getList(rows, earliestTime);
        } else {
            jsonArray = commonService.getList(rows);
        }

        if (jsonArray.isEmpty()) {        // 未获取到消息
            jsonObject.put("result", Constants.GET_STATUS_FAIL);
            jsonObject.put("msg", Msgs.GET_STATUS_FAIL);
        } else {                           // 获取到消息
            jsonObject.put("result", Constants.GET_STATUS_SUCCESS);
            jsonObject.put("msg", Msgs.GET_STATUS_SUCCESS);

            jsonObject.put("list", jsonArray);
        }

        return jsonObject;
    }
}
