package com.youtu.service;

import com.youtu.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by jiax on 2016/8/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class UserServiceTest {
    @Resource
    private UserDao userDao;

    @Test
    public void validation() throws Exception {
        String result = userDao.validation("0","1");
        System.out.println(result);
    }

}