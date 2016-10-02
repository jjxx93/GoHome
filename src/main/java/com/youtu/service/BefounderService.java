package com.youtu.service;

import com.youtu.entity.Befounder;

import java.util.List;

/**
 * Created by jiax on 2016/10/2.
 */
public interface BefounderService {
    /**
     * 添加疑似走失者信息
     *
     * @param founderUuid
     * @param foundLocation
     * @param foundTime
     * @param picture
     * @return
     */
    Boolean addBefounder(String founderUuid, String foundLocation, String foundTime, String picture, String state);

    /**
     * 获取疑似走失者信息
     *
     * @param founderUuid
     * @return
     */
    List<Befounder> getBefounder(String founderUuid);
}
