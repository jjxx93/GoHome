package cn.gohome.service;

import cn.gohome.entity.Report;

/**
 * Created by jiax on 2016/11/10.
 */
public interface ReportService {
    /**
     * 新增/上传报告
     * @param aimType
     * @param aimUuid
     * @param fakeNum
     * @param illegalNum
     * @param harmfulNum
     * @param trashyNum
     * @return
     */
    Boolean addReport (String aimType, String aimUuid, int fakeNum, int illegalNum, int harmfulNum, int trashyNum);

    /**
     * 根据aimType和aimUuid查找举报信息
     * @param aimType
     * @param aimUuid
     * @return
     */
    Report getReportByAimTypeAndAimUuid (String aimType, String aimUuid);

    /**
     * 根据uuid查找举报信息
     * @param uuid
     * @return
     */
    Report getReportByUuid (String uuid);
}
