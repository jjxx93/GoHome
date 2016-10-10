package com.youtu.dao;

import com.youtu.entity.Befounder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jiax on 2016/10/2.
 */
public interface BefounderDao {
    /**
     * 添加疑似走失者信息
     *
     * @param uuid
     * @param founderUuid
     * @param foundLocation
     * @param foundTime
     * @param picture
     * @return
     */
    int insertBefounder(@Param("uuid") String uuid, @Param("founderUuid") String founderUuid, @Param("foundLocation") String foundLocation,
                        @Param("foundTime") String foundTime, @Param("picture") String picture, @Param("remarks") String remarks, @Param("state") String state);

    /**
     * 根据用户uuid查找疑似走失者信息
     *
     * @param founderUuid
     * @return
     */
    List<Befounder> queryByFounderUuid(@Param("founderUuid") String founderUuid);

    /**
     * 根据用户uuid和uuid查找疑似走失者照片
     *
     * @param uuid
     * @param founderUuid
     * @return
     */
    Befounder queryByUuidAndFounderUuid(@Param("uuid") String uuid, @Param("founderUuid") String founderUuid);

    /**
     * 添加年龄和性别信息
     * @param uuid
     * @param age
     * @param ageRange
     * @param gender
     * @return
     */
    int uploadAgeAndGender(@Param("uuid") String uuid, @Param("age") int age, @Param("ageRange") int ageRange,
                           @Param("gender") String gender, @Param("state") String state);

    /**
     * 更新信息
     *
     * @param uuid
     * @param age
     * @param ageRange
     * @param gender
     * @param remarks
     * @param state
     * @return
     */
    int uploadBefounder(@Param("uuid") String uuid, @Param("age") int age, @Param("ageRange") int ageRange,
                        @Param("gender") String gender, @Param("remarks") String remarks, @Param("state") String state);

    /**
     * 根据年龄性别查数据
     *
     * @param maxAge
     * @param minAge
     * @param gender
     * @return
     */
    List<Befounder> queryPictureByMaxMinAgeAndGender(@Param("minAge") int minAge, @Param("maxAge") int maxAge, @Param("gender") String gender);
}
