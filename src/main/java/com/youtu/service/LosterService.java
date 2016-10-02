package com.youtu.service;

import com.youtu.entity.Loster;

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
     * 添加丢失用户
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

    /**
     * 根据年龄和性别信息匹配走失者
     *
     * @param age
     * @param ageRange
     * @param gender
     * @return
     */
    List<Loster> matchLosterByAgeAndGender(int age, int ageRange, int gender);
}
