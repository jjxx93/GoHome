package com.youtu.service;

import com.youtu.entity.Lost;

import java.util.List;

/**
 * Created by jiax on 2016/8/22.
 */
public interface LostService {
    /**
     * 查询单条Lost表记录
     * @param id
     * @return
     */
    Lost getById(int id);

    /**
     * 查询所有Lost表记录
     * @return
     */
    List<Lost> getLostList();
}
