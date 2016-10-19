package com.youtu.dao;

import com.youtu.entity.Loster;
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
    List<Loster> queryPictureByMaxMinAgeAndGender(@Param("minAge") int minAge, @Param("maxAge") int maxAge, @Param("gender") String gender);

    /**
     * 插入新丢失用户数据
     * @param losterUuid
     * @param losterName
     * @param age
     * @param losterBirthday
     * @param gender
     * @param height
     * @param lostDate
     * @param picture
     * @param lostLocation
     * @param remarks
     * @param datasource
     * @return
     */
    int insertLoster(@Param("losterUuid") String losterUuid, @Param("losterName") String losterName, @Param("age") int age,
                     @Param("losterBirthday") String losterBirthday, @Param("gender") String gender, @Param("height") int height,
                     @Param("lostDate") String lostDate, @Param("picture") String picture, @Param("lostLocation") String lostLocation,
                     @Param("remarks") String remarks, @Param("datasource") Character datasource, @Param("sourceId") String sourceId,
                     @Param("updateTime") String updateTime);

    /**
     * 根据上传者uuid查数据
     *
     * @param sourceId
     * @return
     */
    List<Loster> queryBySourceId(@Param("sourceId") String sourceId);

    /**
     * 根据走失者uuid查数据
     *
     * @param losterUuid
     * @return
     */
    Loster queryByLosterUuid(@Param("losterUuid") String losterUuid);

    /**
     * 根据uuid更新数据
     *
     * @param losterUuid
     * @return
     */
    int updateLoster(@Param("losterUuid") String losterUuid, @Param("losterName") String losterName, @Param("age") int age,
                     @Param("losterBirthday") String losterBirthday, @Param("gender") String gender, @Param("height") int height,
                     @Param("lostDate") String lostDate, @Param("picture") String picture, @Param("lostLocation") String lostLocation,
                     @Param("remarks") String remarks, @Param("sourceId") String sourceId, @Param("updateTime") String updateTime);

    /**
     * 根据uuid删除数据
     *
     * @param losterUuid
     * @param sourceId
     * @return
     */
    int deleteLoster(@Param("losterUuid") String losterUuid, @Param("sourceId") String sourceId);

    /**
     * 获取最新的rows条走失者信息列表
     *
     * @param rows
     * @return
     */
    List<Loster> queryLosterList(@Param("rows") int rows);

    /**
     * 获取最新的rows条走失者信息列表
     *
     * @return
     * @Param int rows
     */
    List<Loster> queryLosterListByUpdateTime(@Param("updateTime") String updateTime, @Param("rows") int rows);
}
