package com.youtu.service;

import com.alibaba.fastjson.JSONObject;
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
     * @param remarks
     * @return
     */
    boolean addLoster(String userUuid, String losterName, String losterBirthday, String gender, int height, String lostDate,
                      String picture, String lostLocation, String remarks);

    /**
     * 根据年龄和性别信息匹配走失者
     * @param age
     * @param ageRange
     * @param gender
     * @return
     */
    List<Loster> matchLosterByAgeAndGender(int age, int ageRange, int gender);

    /**
     * 根据照片、年龄和性别信息匹配走失者
     * @param picture
     * @return
     */
    JSONObject matchLosterByPictureAgeAndGender(String picture, LosterService losterService);

    /**
     * 根据上传者uuid查数据
     *
     * @param userUuid
     * @return
     */
    List<Loster> getLosterByUserUuid(String userUuid);

    /**
     * 根据走失者uuid查数据
     *
     * @param losterUuid
     * @return
     */
    Loster getLosterByLosterUuid(String losterUuid);

    /**
     * 根据走失者uuid修改数据
     *
     * @param userUuid
     * @param losterName
     * @param losterBirthday
     * @param gender
     * @param height
     * @param lostDate
     * @param picture
     * @param lostLocation
     * @param remarks
     * @return
     */
    Boolean modifyLosterByLosterUuid(String userUuid, String losterUuid, String losterName, String losterBirthday, String gender, int height, String lostDate,
                                     String picture, String lostLocation, String remarks);

    /**
     * 根据uuid删除数据
     *
     * @param userUuid
     * @param losterUuid
     * @return
     */
    Boolean deleteLoster(String userUuid, String losterUuid);

    /**
     * 获取最新的rows条走失者信息列表
     *
     * @param rows
     * @return
     */
    List<Loster> getLosterList(int rows);

    /**
     * 获取最新的rows条走失者信息列表
     *
     * @param rows
     * @return
     */
    List<Loster> getLosterListByUpdateTime(String updateTime, int rows);
}
