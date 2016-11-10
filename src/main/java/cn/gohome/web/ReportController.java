package cn.gohome.web;

import cn.gohome.common.Constants;
import cn.gohome.common.Msgs;
import cn.gohome.entity.Report;
import cn.gohome.service.ReportService;
import cn.gohome.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by jiax on 2016/11/10.
 */
@Controller
@ResponseBody
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private UserService userService;

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/addReport", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addReport(String aimType, String aimUuid, String userUuid, int reportType) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);      // 检查用户状态

        if (jsonObject == null) {
            jsonObject = new JSONObject();

            int fakeNum = 0, illegalNum = 0, harmfulNum = 0, trashyNum = 0;
            switch (reportType) {
                case 0: fakeNum = 1; break;
                case 1: illegalNum = 1; break;
                case 2: harmfulNum = 1; break;
                case 3: trashyNum = 1; break;
                default: fakeNum = 1; break;
            }

            // 上传数据成功
            if (reportService.addReport(aimType, aimUuid, fakeNum, illegalNum, harmfulNum, trashyNum)) {
                jsonObject.put("result", Constants.ADD_REPORT_SUCCESS);
                jsonObject.put("msg", Msgs.ADD_REPORT_SUCCESS);
            } else {    // 上传数据失败
                jsonObject.put("result", Constants.ADD_REPORT_FAILURE);
                jsonObject.put("msg", Msgs.ADD_REPORT_FAILURE);
            }
        }

        return jsonObject;
    }

    @RequestMapping(value = "/getReport", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> addReport(String aimType, String aimUuid, String userUuid) {
        JSONObject jsonObject = userService.validationUserUuid(userUuid);      // 检查用户状态

        if (jsonObject == null) {
            jsonObject = new JSONObject();

            Report report = reportService.getReportByAimTypeAndAimUuid(aimType, aimUuid);

            if (report != null) {   // 获取到report数据
                jsonObject.put("report", report);
                jsonObject.put("result", Constants.GET_REPORT_SUCCESS);
                jsonObject.put("msg", Msgs.GET_REPORT_SUCCESS);
            } else {                // 获取不到report数据
                jsonObject.put("result", Constants.GET_REPORT_FAILURE);
                jsonObject.put("msg", Msgs.GET_REPORT_FAILURE);
            }
        }

        return jsonObject;
    }
}
