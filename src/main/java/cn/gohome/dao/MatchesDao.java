package cn.gohome.dao;

import cn.gohome.entity.Matches;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jiax on 2016/10/2.
 */
@Repository
public interface MatchesDao {
    /**
     * 增：插入match数据
     *
     * @param userUuid
     * @param befounderUuid
     * @param losterUuid
     * @param similarity
     * @return
     */
    int insertMatches(@Param("uuid") String uuid, @Param("userUuid") String userUuid, @Param("befounderUuid") String befounderUuid, @Param("losterUuid") String losterUuid,
                      @Param("similarity") int similarity, @Param("state") String state);

    /**
     * 删：删除疑似走失者信息
     *
     * @param userUuid
     * @param befounderUuid
     * @return
     */
    int deleteMatches(@Param("userUuid") String userUuid, @Param("befounderUuid") String befounderUuid);

    /**
     * 查：查找match数据
     *
     * @param userUuid
     * @param befounderUuid
     * @return
     */
    List<Matches> queryByUserUuidBefounderUuid(@Param("userUuid") String userUuid, @Param("befounderUuid") String befounderUuid);
}
