package com.youtu.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by jiax on 2016/8/23.
 */
public interface UserDao {

    /**
     * 验证账号密码是否匹配
     * @param user_uuid
     * @param password
     * @return
     */
    String validation(@Param("user_uuid")String user_uuid, @Param("password")String password);
}
