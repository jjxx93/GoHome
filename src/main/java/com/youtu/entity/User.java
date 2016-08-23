package com.youtu.entity;

/**
 * Created by jiax on 2016/8/23.
 */
public class User {
    private int id;
    private String user_uuid;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_uuid() {
        return user_uuid;
    }

    public void setUser_uuid(String user_uuid) {
        this.user_uuid = user_uuid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "id=" + id +
                ", user_uuid='" + user_uuid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
