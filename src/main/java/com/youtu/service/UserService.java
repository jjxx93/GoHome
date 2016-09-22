package com.youtu.service;

import com.youtu.entity.User;

/**
 * Created by jiax on 2016/8/23.
 */
public interface UserService {

    /**
     * 新增用户
     * @param userName
     * @param password
     * @return
     */
    User addUserNameAndPassword (String userName, String password);

    /**
     * 验证账号密码
     * @param userName
     * @param password
     * @return
     */
    User validation(String userName, String password);

    /**
     * 验证账号密码
     * @param userUuid
     * @return
     */
    int validationUserUuid(String userUuid);

    /**
     * 查询用户名是否存在
     * @param userName
     * @return
     */
    Boolean isUserNameExisted (String userName);
}
