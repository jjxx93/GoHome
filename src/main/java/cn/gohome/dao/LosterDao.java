package cn.gohome.dao;

import cn.gohome.entity.Loster;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jiax on 2016/9/21.
 */
@Repository
public interface LosterDao {
    /**
     * 增：插入新丢失用户数据
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
                     @Param("createTime") String createTime, @Param("updateTime") String updateTime);

    /**
     * 删：根据uuid删除数据
     *
     * @param losterUuid
     * @param sourceId
     * @return
     */
    int deleteLoster(@Param("losterUuid") String losterUuid, @Param("sourceId") String sourceId);

    /**
     * 改：根据uuid更新数据
     *
     * @param losterUuid
     * @return
     */
    int updateLoster(@Param("losterUuid") String losterUuid, @Param("losterName") String losterName, @Param("age") int age,
                     @Param("losterBirthday") String losterBirthday, @Param("gender") String gender, @Param("height") int height,
                     @Param("lostDate") String lostDate, @Param("picture") String picture, @Param("lostLocation") String lostLocation,
                     @Param("remarks") String remarks, @Param("sourceId") String sourceId, @Param("updateTime") String updateTime);

    /**
     * 查：根据年龄性别查数据
     * @param age
     * @param gender
     * @return
     */
    List<String> queryPictureByAgeAndGender(@Param("age") int age, @Param("gender") String gender);

    /**
     * 查：根据年龄性别查数据
     * @param maxAge
     * @param minAge
     * @param gender
     * @return
     */
    List<Loster> queryPictureByMaxMinAgeAndGender(@Param("minAge") int minAge, @Param("maxAge") int maxAge, @Param("gender") String gender);

    /**
     * 查：根据上传者uuid查数据
     *
     * @param sourceId
     * @return
     */
    List<Loster> queryBySourceId(@Param("sourceId") String sourceId);

    /**
     * 查：根据走失者uuid查数据
     *
     * @param losterUuid
     * @return
     */
    Loster queryByLosterUuid(@Param("losterUuid") String losterUuid);

    /**
     * 查：获取最新的rows条走失者信息列表
     *
     * @param rows
     * @return
     */
    List<Loster> queryLosterList(@Param("rows") int rows);

    /**
     * 查：获取updateTime时间之前的rows条走失者信息列表
     * @param updateTime
     * @param rows
     * @return
     */
    List<Loster> queryLosterListBeforeUpdateTime(@Param("updateTime") String updateTime, @Param("rows") int rows);

    /**
     * 查：获取updateTime之后的rows条走失者信息列表
     * @param updateTime
     * @param rows
     * @return
     */
    List<Loster> queryLosterListAfterUpdateTime(@Param("updateTime") String updateTime, @Param("rows") int rows);
}
