package com.youtu.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jiax on 2016/9/21.
 */
@Repository
public interface LosterDao {
    /**
     * 根据年龄性别查数据
     * @param age
     * @param gender
     * @return
     */
    List<String> queryPictureByAgeAndGender(@Param("age") int age, @Param("gender") String gender);

    /**
     * 根据年龄性别查数据
     * @param maxAge
     * @param minAge
     * @param gender
     * @return
     */
    List<String> queryPictureByMaxMinAgeAndGender(@Param("minAge") int minAge, @Param("maxAge") int maxAge, @Param("gender") String gender);

    /**
     * 插入新丢失用户数据
     *
     * @param losterUuid
     * @param losterName
     * @param age
     * @param losterBirthday
     * @param gender
     * @param height
     * @param lostDate
     * @param picture
     * @param lostLocation
     * @param characteristic
     * @param datasource
     * @return
     */
    int insertLoster(@Param("losterUuid") String losterUuid, @Param("losterName") String losterName, @Param("age") int age,
                     @Param("losterBirthday") String losterBirthday, @Param("gender") Character gender, @Param("height") int height,
                     @Param("lostDate") String lostDate, @Param("picture") String picture, @Param("lostLocation") String lostLocation,
                     @Param("characteristic") String characteristic, @Param("datasource") Character datasource);

}
