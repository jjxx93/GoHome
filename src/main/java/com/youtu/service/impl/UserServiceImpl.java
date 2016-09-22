package com.youtu.service.impl;

import com.youtu.common.GetUUIDNumber;
import com.youtu.common.YoutuConstants;
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
    public User addUserNameAndPassword(String userName, String password) {
        String UserUuid = GetUUIDNumber.createUUIDNumber();
        userDao.addUser(userName, password, GetUUIDNumber.createUUIDNumber());
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setUserUuid(UserUuid);
        return user;
    }

    @Override
    public User validation(String userName, String password) {
        return userDao.queryByUserNameAndPassword(userName, password);
    }

    @Override
    public int validationUserUuid(String userUuid) {
        User user = userDao.queryByUserUuid(userUuid);
        if (user == null) {
            return YoutuConstants.USER_NOT_EXIST;
        } else {
            return Integer.valueOf(user.getExamineState());
        }
    }

    @Override
    public Boolean isUserNameExisted(String userName) {
        if (userDao.queryByUserName(userName) != null) {
            return true;
        } else {
            return false;
        }
    }


}
