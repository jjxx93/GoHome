package com.youtu.entity;

/**
 * Created by jiax on 2016/9/21.
 */
public class Face {
    private String faceId;
    private int imgHeight;
    private int imgWidth;
    private int gender;
    private int age;
    private int range;
    private String faceUrl;
    private int similarity;

    public Face(String faceId, int imgHeight, int imgWidth, int gender, int age, int range, String faceUrl, int similarity) {
        this.faceId = faceId;
        this.imgHeight = imgHeight;
        this.imgWidth = imgWidth;
        this.gender = gender;
        this.age = age;
        this.range = range;
        this.faceUrl = faceUrl;
        this.similarity = similarity;
    }

    @Override
    public String toString() {
        return "Face{" +
                "faceId='" + faceId + '\'' +
                ", imgHeight=" + imgHeight +
                ", imgWidth=" + imgWidth +
                ", gender=" + gender +
                ", age=" + age +
                ", range=" + range +
                ", faceUrl='" + faceUrl + '\'' +
                ", similarity=" + similarity +
                '}';
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public int getSimilarity() {
        return similarity;
    }

    public void setSimilarity(int similarity) {
        this.similarity = similarity;
    }

    public Face(String faceId, int imgHeight, int imgWidth, int gender, int age, int range) {
        this.faceId = faceId;
        this.imgHeight = imgHeight;
        this.imgWidth = imgWidth;
        this.gender = gender;
        this.age = age;
        this.range = range;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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
}
