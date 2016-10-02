package com.youtu.service;

import java.util.List;

/**
 * Created by jiax on 2016/9/21.
 */
public interface LosterService {
    /**
     * 获得地址列表
     * @param age
     * @param gender
     * @return
     */
    List<String> getUrl (int age, int gender);

    /**
     * 获得地址列表
     * @param maxAge
     * @param minAge
     * @param gender
     * @return
     */
    List<String> getUrl (int minAge, int maxAge ,int gender);

    /**
     * 添加丢失用户
     *
     * @param losterName
     * @param losterBirthday
     * @param gender
     * @param height
     * @param lostDate
     * @param picture
     * @param lostLocation
     * @param characteristic
     * @return
     */
    boolean addLoster(String losterName, String losterBirthday, String gender, int height, String lostDate,
                      String picture, String lostLocation, String characteristic);
}
