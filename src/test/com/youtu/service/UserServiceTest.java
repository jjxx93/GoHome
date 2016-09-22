package com.youtu.service;

import com.youtu.dao.UserDao;
import com.youtu.dao.UserDaoTest;
import com.youtu.entity.User;
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

    @Resource
    private UserService userService;

    @Test
    public void validation() throws Exception {
        UserDaoTest test = new UserDaoTest();
        test.validation();
    }

    @Test
    public void addUserNameAndPassword() throws Exception {

    }

    @Test
    public void validationUserUuid() throws Exception {
        System.out.println(userService.validationUserUuid("1"));
    }

    @Test
    public void isUserNameExisted() throws Exception {

    }



}