package com.youtu.dao;

import com.youtu.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by jiax on 2016/8/23.
 */
@Repository
public interface UserDao {
    /**
     * 新增用户行
     * @param userName
     * @param password
     */
    void addUser(@Param("userName")String userName, @Param("password")String password);

    /**
     * 验证账号密码是否匹配
     * @param userName
     * @param password
     * @return
     */
    User queryByUsernameAndPassword(@Param("userName")String userName, @Param("password")String password);
}
