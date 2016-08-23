package com.youtu.service;

/**
 * Created by jiax on 2016/8/23.
 */
public interface UserService {

    /**
     * 验证账号密码
     * @param user_uuid
     * @param password
     * @return
     */
    boolean validation(String user_uuid, String password);
}
