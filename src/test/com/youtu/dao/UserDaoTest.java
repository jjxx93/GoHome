package com.youtu.dao;

import cn.gohome.dao.UserDao;
import cn.gohome.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by jiax on 2016/9/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    @Test
    public void validation() throws Exception {
        User user = new User();
        System.out.println(userDao.queryByUserNameAndPassword(user.getUserName(), user.getPassword()));
        user.setUserName("admin");
        user.setPassword("1226");
        System.out.println(userDao.queryByUserNameAndPassword(user.getUserName(), user.getPassword()));
    }

}