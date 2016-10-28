package com.youtu.entity;

/**
 * Created by jiax on 2016/10/12.
 */
public class Talks {
    private int id;
    private String Uuid;
    private String picture;
    private String texts;
    private String userUuid;
    private String createTime;
    private String updateTime;

    public Talks(int id, String uuid, String picture, String texts, String userUuid, String createTime, String updateTime) {
        this.id = id;
        Uuid = uuid;
        this.picture = picture;
        this.texts = texts;
        this.userUuid = userUuid;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        Uuid = uuid;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
