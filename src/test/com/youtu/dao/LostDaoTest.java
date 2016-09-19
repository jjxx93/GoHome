package com.youtu.dao;

import com.youtu.entity.Lost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by jiax on 2016/6/14.
 * 配置junit和spring整合，junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class LostDaoTest {
    @Resource
    private LostDao lostDao;

    @Test
    public void queryById() throws Exception {
        int id = 1;
        Lost lost = lostDao.queryById(id);
        System.out.println(lost.getLostUuid());
        System.out.println(lost);
    }

}