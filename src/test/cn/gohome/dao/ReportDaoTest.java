package cn.gohome.dao;

import cn.gohome.common.GetUUIDNumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by jiax on 2016/11/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ReportDaoTest {
    @Resource
    private ReportDao reportDao;

    @Test
    public void insertReport() throws Exception {
        System.out.println(reportDao.insertReport(GetUUIDNumber.createUUIDNumber(), "1",
                "b033991d088d426faf38cc40c2996ff7", 1, 0, 0, 0));
    }

    @Test
    public void updateReport() throws Exception {
        reportDao.updateReport("1", "b033991d088d426faf38cc40c2996ff7", 1, 0, 0, 0);
    }

    @Test
    public void queryReportByAimTypeAndAimUuid() throws Exception {
        System.out.println(reportDao.queryReportByAimTypeAndAimUuid("1", "b033991d088d426faf38cc40c2996ff7"));
    }

    @Test
    public void queryReportByUuid() throws Exception {
        System.out.println(reportDao.queryReportByUuid("336b43aa32b9408792447cf583955e71"));
    }

}