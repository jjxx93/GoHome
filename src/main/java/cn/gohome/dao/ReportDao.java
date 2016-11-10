package cn.gohome.dao;

import cn.gohome.entity.Report;
import org.apache.ibatis.annotations.Param;

/**
 * Created by jiax on 2016/11/10.
 */
public interface ReportDao {
    /**
     * 增——新增举报
     * @param uuid          举报uuid
     * @param aimType       举报目标类型（0走失者，1疑似走失者，2说说）
     * @param aimUuid       目标uuid
     * @param fakeNum       新增虚假信息举报数量
     * @param illegalNum    新增违法信息举报数量
     * @param harmfulNum    新增有害信息举报数量
     * @param trashyNum     新增圾营销举报数量
     * @return
     */
    int insertReport (@Param("uuid") String uuid, @Param("aimType") String aimType, @Param("aimUuid") String aimUuid,
                      @Param("fakeNum") int fakeNum, @Param("illegalNum") int illegalNum,
                      @Param("harmfulNum") int harmfulNum, @Param("trashyNum") int trashyNum);

    /**
     * 改——修改一条举报信息（新增举报数）
     * @param aimType
     * @param aimUuid
     * @param fakeNum
     * @param illegalNum
     * @param harmfulNum
     * @param trashyNum
     * @return
     */
    int updateReport (@Param("aimType") String aimType, @Param("aimUuid") String aimUuid, @Param("fakeNum") int fakeNum,
                      @Param("illegalNum") int illegalNum, @Param("harmfulNum") int harmfulNum, @Param("trashyNum") int trashyNum);

    /**
     * 查——根据aimType和aimUuid查找举报信息
     * @param aimType
     * @param aimUuid
     * @return
     */
    Report queryReportByAimTypeAndAimUuid (@Param("aimType") String aimType, @Param("aimUuid") String aimUuid);

    /**
     * 查——根据uuid查找举报信息
     * @param uuid
     * @return
     */
    Report queryReportByUuid (@Param("uuid") String uuid);
}
