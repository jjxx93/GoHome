package cn.gohome.dao;

import cn.gohome.entity.Talks;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jiax on 2016/10/28.
 */
public interface TalksDao {
    /**
     * 增：在数据库中插入新talks数据
     *
     * @param talks
     * @return
     */
    int insertTalks(Talks talks);

    /**
     * 删：删除talks数据
     *
     * @param userUuid
     * @param uuid
     * @return
     */
    int deleteTalks(@Param("userUuid") String userUuid, @Param("uuid") String uuid);

    /**
     * 改：修改talks数据
     *
     * @param talks
     * @return
     */
    int updateTalks(Talks talks);

    /**
     * 查：根据articleUuid查找talks数据
     *
     * @param uuid
     * @return
     */
    Talks queryTalksByUuid(@Param("uuid") String uuid);

    /**
     * 查：根据userUuid查找talks数据列表
     *
     * @param userUuid
     * @return
     */
    List<Talks> queryTalksByUserUuid(@Param("userUuid") String userUuid);

    /**
     * 查：查找最新的rows条talks数据
     *
     * @param rows
     * @return
     */
    List<Talks> queryTalks(@Param("rows") int rows);

    /**
     * 查：查找UpdateTime时间前的rows条talks数据
     *
     * @param rows
     * @param updateTime
     * @return
     */
    List<Talks> queryTalksBeforeUpdateTime(@Param("updateTime") String updateTime, @Param("rows") int rows);

    /**
     * 查：查找UpdateTime时间后的rows条talks数据
     *
     * @param rows
     * @param updateTime
     * @return
     */
    List<Talks> queryTalksAfterUpdateTime(@Param("updateTime") String updateTime, @Param("rows") int rows);
}
