package cn.gohome.web;

import cn.gohome.common.Constants;
import cn.gohome.common.Msgs;
import cn.gohome.service.BefounderService;
import cn.gohome.service.CommonService;
import cn.gohome.service.LosterService;
import cn.gohome.service.UserService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private UserService userService;

    @Autowired
    private BefounderService befounderService;

    @Autowired
    private LosterService losterService;

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
        logger.info("GohomeController.getLosterList latestTime={}, earliestTime={}, rows={}",
                latestTime, earliestTime, rows);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray;

        if (latestTime != null) {           // 要查找latestTime时间之后的消息
            jsonArray = commonService.getList(latestTime, rows);
        } else if (earliestTime != null) {  // 要查找earliestTime时间之前的消息
            jsonArray = commonService.getList(rows, earliestTime);
        } else {
            jsonArray = commonService.getList(rows);
        }

        if (jsonArray == null || jsonArray.isEmpty()) {        // 未获取到消息
            jsonObject.put("result", Constants.GET_STATUS_FAIL);
            jsonObject.put("msg", Msgs.GET_STATUS_FAIL);
        } else {                           // 获取到消息
            jsonObject.put("result", Constants.GET_STATUS_SUCCESS);
            jsonObject.put("msg", Msgs.GET_STATUS_SUCCESS);

            jsonObject.put("list", jsonArray);
        }

        return jsonObject;
    }

    /**
     * 匹配信息
     * 家人操作：根据走失者照片、年龄、性别等信息 匹配 疑似走失者
     * 志愿者操作：根据疑似走失者照片、年龄、性别等信息 匹配 走失者
     * @param userUuid
     * @param picture
     * @param userType
     * @return
     */
    @RequestMapping(value = "/match", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> match(String userUuid, String picture, String userType) {
        logger.info("GohomeController.match userUuid={}, picture={}, userType={}",
                userUuid, picture, userType);
        // 检查用户uuid
        JSONObject jsonObject = userService.validationUserUuid(userUuid);

        if (jsonObject == null) {   // 检查用户uuid通过
            if (userType.equals("0")) {     // 家人操作
                return losterService.matchLosterByPictureAgeAndGender(picture, losterService);
            } else {                        // 志愿者操作
                return befounderService.matchBefounderByPictureAgeAndGender(picture, befounderService);
            }
        }

        return jsonObject;
    }
}
