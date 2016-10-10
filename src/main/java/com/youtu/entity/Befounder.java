package com.youtu.entity;

/**
 * Created by jiax on 2016/10/2.
 */
public class Befounder {
    private int id;
    private String uuid;
    private String founderUuid;
    private String foundLocation;
    private String foundTime;
    private String picture;
    private String remarks;
    private int age;
    private int range;
    private int gender;
    private int state;

    @Override
    public String toString() {
        return "Befounder{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", founderUuid='" + founderUuid + '\'' +
                ", foundLocation='" + foundLocation + '\'' +
                ", foundTime='" + foundTime + '\'' +
                ", picture='" + picture + '\'' +
                ", remarks='" + remarks + '\'' +
                ", age=" + age +
                ", range=" + range +
                ", gender=" + gender +
                ", state=" + state +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFounderUuid() {
        return founderUuid;
    }

    public void setFounderUuid(String founderUuid) {
        this.founderUuid = founderUuid;
    }

    public String getFoundLocation() {
        return foundLocation;
    }

    public void setFoundLocation(String foundLocation) {
        this.foundLocation = foundLocation;
    }

    public String getFoundTime() {
        return foundTime;
    }

    public void setFoundTime(String foundTime) {
        this.foundTime = foundTime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
