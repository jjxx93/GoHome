package com.youtu.service;

import com.youtu.entity.Matches;

import java.util.List;

/**
 * Created by jiax on 2016/10/2.
 */
public interface MatchesService {
    /**
     * 插入match数据
     *
     * @param userUuid
     * @param befounderUuid
     * @param losterUuid
     * @param similarity
     * @param state
     * @return
     */
    boolean addMatches(String userUuid, String befounderUuid, String losterUuid, int similarity, String state);

    /**
     * 查找match数据
     *
     * @param userUuid
     * @param befounderUuid
     * @return
     */
    List<Matches> getMatchesList(String userUuid, String befounderUuid);
}
