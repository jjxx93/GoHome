package com.youtu.dao;

import com.youtu.entity.Loster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jiax on 2016/10/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class LosterDaoTest {
    @Resource
    private LosterDao losterDao;

    @Test
    public void queryLosterList() throws Exception {
        List<Loster> losters = losterDao.queryLosterList(10);

        for (Loster loster : losters) {
            System.out.println(loster.getUpdateTime());
        }
    }

    @Test
    public void queryLosterListByUpdateTime() throws Exception {
        //List<Loster> losters = losterDao.queryLosterListBeforeUpdateTime("2016-10-06 20:42:46-943", 5);
        List<Loster> losters = losterDao.queryLosterListAfterUpdateTime("2016-10-06 20:42:46-943", 5);

        for (Loster loster : losters) {
            System.out.println(loster.getUpdateTime());
        }
    }

}