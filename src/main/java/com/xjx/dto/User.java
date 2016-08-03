package com.xjx.dto;

import java.sql.Timestamp;

/**
 * Created by jiax on 2016/7/21.
 */
public class User {
    private long user_id;
    private String name;
    private int degree;
    private Timestamp createTime;

    public User(long user_id, String name, int degree, Timestamp createTime) {
        this.user_id = user_id;
        this.name = name;
        this.degree = degree;
        this.createTime = createTime;
    }

    public long getId() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public int getDegree() {
        return degree;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", degree=" + degree +
                ", createTime=" + createTime +
                '}';
    }
}
