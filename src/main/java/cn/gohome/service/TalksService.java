package cn.gohome.service;

import cn.gohome.entity.Talks;

import java.util.List;

/**
 * Created by jiax on 2016/10/28.
 */
public interface TalksService {
    /**
     * 添加talks列
     *
     * @param talks
     * @return
     */
    Boolean addTalks(Talks talks);

    /**
     * 删除talks列
     *
     * @param userUuid
     * @param uuid
     * @return
     */
    Boolean deleteTalks(String userUuid, String uuid);

    /**
     * 修改talks列
     *
     * @param talks
     * @return
     */
    Boolean modifyTalks(Talks talks);

    /**
     * 根据uuid查找article
     *
     * @param uuid
     * @return
     */
    Talks getTalksByUuid(String uuid);

    /**
     * 根据userUuid查找uuid列表
     *
     * @param userUuid
     * @return
     */
    List<Talks> getTalksByUserUuid(String userUuid);

    /**
     * 查找rows行talks数据
     *
     * @param rows
     * @return
     */
    List<Talks> getTalks(int rows);

    /**
     * 查找rows行lastUpdateTime时间之前的talks数据
     *
     * @param rows
     * @return
     */
    List<Talks> getTalks(int rows, String updateTime);
}
