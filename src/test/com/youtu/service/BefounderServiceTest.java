package com.youtu.service;

import cn.gohome.service.BefounderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jiax on 2016/10/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class BefounderServiceTest {
    @Autowired      //自动注入
    private BefounderService befounderService;

    @Test
    public void addBefounder() throws Exception {
        //System.out.println(befounderService.addBefounder("440f068e4e3649588994d7d627a1631b", "中国", "2008-08-08 10:10:10",
        //       "http://odqvl1oxn.bkt.clouddn.com/jpg/1366_768_4605.jpg", "123", "0"));
    }

}