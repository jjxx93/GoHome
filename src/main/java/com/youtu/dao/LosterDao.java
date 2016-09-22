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
    List<String> queryByAgeAndGender(@Param("age")int age, @Param("gender")String gender);

    /**
     * 根据年龄性别查数据
     * @param maxAge
     * @param minAge
     * @param gender
     * @return
     */
    List<String> queryByMaxMinAgeAndGender(@Param("minAge")int minAge, @Param("maxAge")int maxAge, @Param("gender")String gender);
}
