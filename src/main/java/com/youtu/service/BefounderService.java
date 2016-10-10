package com.youtu.service;

import com.alibaba.fastjson.JSONObject;
import com.youtu.entity.Befounder;
import com.youtu.entity.Loster;

import java.util.List;

/**
 * Created by jiax on 2016/10/2.
 */
public interface BefounderService {
    /**
     * 添加疑似走失者信息
     *
     * @param founderUuid
     * @param foundLocation
     * @param foundTime
     * @param picture
     * @return
     */
    Boolean addBefounder(String founderUuid, String foundLocation, String foundTime, String picture, String remarks, String state);

    /**
     * 获取疑似走失者信息
     *
     * @param founderUuid
     * @return
     */
    List<Befounder> getBefounder(String founderUuid);

    /**
     * 根据年龄和性别信息匹配走失者
     *
     * @param age
     * @param ageRange
     * @param gender
     * @return
     */
    List<Befounder> matchBefounderByAgeAndGender(int age, int ageRange, int gender);

    /**
     * 根据照片、年龄和性别信息匹配走失者
     *
     * @param picture
     * @return
     */
    JSONObject matchBefounderByPictureAgeAndGender(String picture, BefounderService befounderService);
}
