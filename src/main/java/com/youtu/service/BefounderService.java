package com.youtu.service;

import com.alibaba.fastjson.JSONObject;
import com.youtu.entity.Befounder;
import com.youtu.entity.Loster;
import org.apache.ibatis.annotations.Param;

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
    Boolean addBefounder(String founderUuid, String foundLocation, String foundTime, String picture,
                         String remarks, String state);

    /**
     * 查找某用户上传的全部疑似走失者信息
     *
     * @param founderUuid
     * @return
     */
    List<Befounder> getBefounders(String founderUuid);

    /**
     * 查找某条走失者信息
     *
     * @param uuid
     * @return
     */
    Befounder getBefounder(String uuid);

    /**
     * 修改疑似走失者信息
     *
     * @param uuid
     * @param age
     * @param ageRange
     * @param gender
     * @param remarks
     * @param state
     * @return
     */
    Boolean modifyBefounder(String uuid, int age, int ageRange, String gender, String remarks, String state);

    /**
     * 删除疑似走失者信息与相关的匹配表信息
     *
     * @param userUuid
     * @param uuid
     * @return
     */
    Boolean deleteBefounderAndMatches(String userUuid, String uuid);

    /**
     * 修改年龄性别
     *
     * @param uuid
     * @param age
     * @param ageRange
     * @param gender
     * @param state
     * @return
     */
    Boolean modifyAgeAndGender(String uuid, int age, int ageRange, String gender, String state);

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
