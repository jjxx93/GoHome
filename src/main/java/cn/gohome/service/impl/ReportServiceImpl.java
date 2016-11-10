package cn.gohome.service.impl;

import cn.gohome.common.GetUUIDNumber;
import cn.gohome.dao.ReportDao;
import cn.gohome.entity.Report;
import cn.gohome.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiax on 2016/11/10.
 */
@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    private ReportDao reportDao;

    @Override
    public Boolean addReport(String aimType, String aimUuid, int fakeNum, int illegalNum, int harmfulNum, int trashyNum) {
        if (reportDao.updateReport(aimType, aimUuid, fakeNum, illegalNum, harmfulNum, trashyNum) > 0) {    // 修改成功
            return true;
        } else {        // 修改不成功，可能是数据库无此条消息
            String uuid = GetUUIDNumber.createUUIDNumber();

            // 新增一条数据
            if (reportDao.insertReport(uuid, aimType, aimUuid, fakeNum, illegalNum, harmfulNum, trashyNum) > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Report getReportByAimTypeAndAimUuid(String aimType, String aimUuid) {
        return reportDao.queryReportByAimTypeAndAimUuid(aimType, aimUuid);
    }

    @Override
    public Report getReportByUuid(String uuid) {
        return reportDao.queryReportByUuid(uuid);
    }

}
