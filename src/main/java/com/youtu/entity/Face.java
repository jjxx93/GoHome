package com.youtu.entity;

/**
 * Created by jiax on 2016/9/21.
 */
public class Face {
    private String faceId;
    private int imgHeight;
    private int imgWidth;
    private int gender;
    private int maxAge;
    private int minAge;

    public Face(String faceId, int imgHeight, int imgWidth, int gender, int maxAge, int minAge) {
        this.faceId = faceId;
        this.imgHeight = imgHeight;
        this.imgWidth = imgWidth;
        this.gender = gender;
        this.maxAge = maxAge;
        this.minAge = minAge;
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

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public String toString() {
        return "Face{" +
                "faceId='" + faceId + '\'' +
                ", imgHeight=" + imgHeight +
                ", imgWidth=" + imgWidth +
                ", gender=" + gender +
                ", maxAge=" + maxAge +
                ", minAge=" + minAge +
                '}';
    }
}
