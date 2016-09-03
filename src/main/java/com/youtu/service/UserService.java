package com.youtu.service;

import com.youtu.entity.User;

/**
 * Created by jiax on 2016/8/23.
 */
public interface UserService {

    /**
     * 验证账号密码
     * @param user
     * @return
     */
    User validation(User user);
}
