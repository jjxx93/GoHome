package com.youtu.dao;

import com.youtu.entity.Talks;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jiax on 2016/10/28.
 */
public interface TalksDao {
    /**
     * 在数据库中插入新talks数据
     *
     * @param talks
     * @return
     */
    int insertTalks(Talks talks);

    /**
     * 删除talks数据
     *
     * @param userUuid
     * @param uuid
     * @return
     */
    int deleteTalks(@Param("userUuid") String userUuid, @Param("uuid") String uuid);

    /**
     * 修改talks数据
     *
     * @param talks
     * @return
     */
    int updateTalks(Talks talks);

    /**
     * 根据articleUuid查找talks数据
     *
     * @param uuid
     * @return
     */
    Talks queryTalksByUuid(@Param("uuid") String uuid);

    /**
     * 根据userUuid查找talks数据列表
     *
     * @param userUuid
     * @return
     */
    List<Talks> queryTalksByUserUuid(@Param("userUuid") String userUuid);

    /**
     * 查找talks数据列表
     *
     * @param rows
     * @return
     */
    List<Talks> queryTalks(@Param("rows") int rows);

    /**
     * 查找talks数据列表
     *
     * @param rows
     * @param updateTime
     * @return
     */
    List<Talks> queryTalksByLastUpdateTime(@Param("rows") int rows, @Param("updateTime") String updateTime);

}
