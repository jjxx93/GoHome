package com.youtu.service.impl;

import com.youtu.dao.UserDao;
import com.youtu.entity.User;
import com.youtu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jiax on 2016/8/23.
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //注入Service依赖
    @Autowired      //自动注入
    private UserDao userDao;

    @Override
    public User validation(User user) {
        if (!user.getUser_uuid().equals("") && user.getPassword() != null) {
            User mUser = userDao.validation(user);
            return mUser;
        }
        return null;
    }
}
