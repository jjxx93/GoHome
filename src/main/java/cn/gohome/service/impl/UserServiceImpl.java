package cn.gohome.service.impl;

import cn.gohome.common.Constants;
import cn.gohome.common.GetUUIDNumber;
import cn.gohome.common.Msgs;
import cn.gohome.dao.UserDao;
import cn.gohome.entity.User;
import cn.gohome.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public User addUser(String userName, String password) {
        logger.info("UserServiceImpl.addUser userName={}, password={}", userName, password);

        String UserUuid = GetUUIDNumber.createUUIDNumber();
        userDao.insertUser(userName, password, GetUUIDNumber.createUUIDNumber());
        User user = new User();
        user.setUserName(userName);
        user.setUserUuid(UserUuid);
        return user;
    }

    @Override
    public Boolean changeHeadImg(String userUuid, String headImg) {
        logger.info("UserServiceImpl.changeHeadImg userUuid={}, headImg={}", userUuid, headImg);
        if (userDao.updateHeadImg(userUuid, headImg) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean changePassword(String userUuid, String oldPassword, String newPassword) {
        logger.info("UserServiceImpl.changePassword userUuid={}", userUuid);
        return userDao.updatePassword(userUuid, oldPassword, newPassword) > 0;
    }

    @Override
    public Boolean changeInformation(String userUuid, String telephone, String nickName, String realName,
                                     String sex, String birthday, String city) {
        return userDao.updateUserInformation(userUuid, telephone, nickName, realName, sex, birthday, city) > 0;
    }

    @Override
    public User validation(String userName, String password) {
        return userDao.queryByUserNameAndPassword(userName, password);
    }

    @Override
    public JSONObject validationUserUuid(String userUuid) {
        JSONObject jsonObject = new JSONObject();
        User user = userDao.queryByUserUuid(userUuid);

        if (user == null) {
            jsonObject.put("result", Constants.USER_NOT_EXIST);
            jsonObject.put("msg", Msgs.USER_NOT_EXIST);
            return jsonObject;
        } else {
            int userState = Integer.valueOf(user.getExamineState());
            if (userState == 1) {
                jsonObject.put("result", Constants.USER_DISABLE);
                jsonObject.put("msg", Msgs.USER_DISABLE);
                return jsonObject;
            }
        }

        return null;
    }

    @Override
    public Boolean isUserNameExisted(String userName) {
        return userDao.queryByUserName(userName) != null;
    }

    @Override
    public User getUserByUserUuid(String userUuid) {
        return userDao.queryByUserUuid(userUuid);
    }
}
