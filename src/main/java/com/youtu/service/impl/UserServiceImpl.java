package com.youtu.service.impl;

import com.youtu.dao.UserDao;
import com.youtu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jiax on 2016/8/23.
 */
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //注入Service依赖
    @Autowired      //自动注入
    private UserDao userDao;

    @Override
    public boolean validation(String user_uuid, String password) {
        if (userDao.validation(user_uuid, password) != null) {
            return true;
        }
        return false;
    }
}
