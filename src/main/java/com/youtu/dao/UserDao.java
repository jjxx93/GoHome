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
    void addUser(@Param("userName")String userName, @Param("password")String password, @Param("userUuid")String userUuid);

    /**
     * 验证账号密码是否匹配
     * @param userName
     * @param password
     * @return
     */
    User queryByUserNameAndPassword(@Param("userName")String userName, @Param("password")String password);

    /**
     * 根据用户名查数据
     * @param userName
     * @return
     */
    User queryByUserName(@Param("userName")String userName);
}
