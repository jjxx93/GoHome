package com.youtu.dao;

import com.youtu.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by jiax on 2016/8/23.
 */
@Repository
public interface UserDao {

    /**
     * 验证账号密码是否匹配
     * @param user
     * @return
     */
    User validation(User user);
}
