package cn.gohome.dao;

import cn.gohome.entity.Befounder;
import cn.gohome.entity.Loster;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jiax on 2016/10/2.
 */
public interface BefounderDao {
    /**
     * 增：添加疑似走失者信息
     *
     * @param uuid
     * @param founderUuid
     * @param foundLocation
     * @param foundTime
     * @param picture
     * @return
     */
    int insertBefounder(@Param("uuid") String uuid, @Param("founderUuid") String founderUuid, @Param("foundLocation") String foundLocation,
                        @Param("foundTime") String foundTime, @Param("picture") String picture, @Param("age") int age,
                        @Param("ageRange") int ageRange, @Param("gender") String gender,
                        @Param("remarks") String remarks, @Param("state") String state);

    /**
     * 删：删除一条疑似走失者数据
     *
     * @param uuid
     * @param founderUuid
     * @return
     */
    int deleteBefounder(@Param("uuid") String uuid, @Param("founderUuid") String founderUuid);

    /**
     * 改：添加年龄和性别信息
     * @param uuid
     * @param age
     * @param ageRange
     * @param gender
     * @return
     */
    int uploadAgeAndGender(@Param("uuid") String uuid, @Param("age") int age, @Param("ageRange") int ageRange,
                           @Param("gender") String gender, @Param("state") String state);

    /**
     * 改：更新信息
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
     * 查：根据用户uuid查找疑似走失者信息
     *
     * @param founderUuid
     * @return
     */
    List<Befounder> queryByFounderUuid(@Param("founderUuid") String founderUuid);

    /**
     * 查：根据用户uuid和uuid查找疑似走失者
     *
     * @param uuid
     * @return
     */
    Befounder queryByUuid(@Param("uuid") String uuid);

    /**
     * 查：根据年龄性别查数据
     *
     * @param maxAge
     * @param minAge
     * @param gender
     * @return
     */
    List<Befounder> queryPictureByMaxMinAgeAndGender(@Param("minAge") int minAge, @Param("maxAge") int maxAge, @Param("gender") String gender);

    /**
     * 查：获取最新的rows条疑似走失者信息列表
     *
     * @param rows
     * @return
     */
    List<Befounder> queryBefounderList(@Param("rows") int rows);

    /**
     * 查：获取updateTime时间前的rows条疑似走失者信息列表
     * @param updateTime
     * @param rows
     * @return
     */
    List<Befounder> queryBefounderListBeforeUpdateTime(@Param("updateTime") String updateTime, @Param("rows") int rows);

    /**
     * 查：获取updateTime后的rows条疑似走失者信息列表
     * @param updateTime
     * @param rows
     * @return
     */
    List<Befounder> queryBefounderListAfterUpdateTime(@Param("updateTime") String updateTime, @Param("rows") int rows);
}
