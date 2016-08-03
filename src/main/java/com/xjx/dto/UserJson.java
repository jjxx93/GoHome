package com.xjx.dto;

import java.sql.Timestamp;

/**
 * Created by jiax on 2016/7/21.
 */
public class UserJson extends User {
    private boolean isSuccess;

    public UserJson(User user, boolean isSuccess) {
        super(user.getId(), user.getName(), user.getDegree(), user.getCreateTime());
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    @Override
    public String toString() {

        return "UserJson{" +
                "isSuccess=" + isSuccess +
                '}';
    }
}
