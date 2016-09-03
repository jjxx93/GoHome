package com.youtu.dao;

import com.youtu.entity.Lost;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jiax on 2016/8/22.
 */
@Repository
public interface LostDao {
    /**
     * 根据id查询Lost表数据
     * @param id
     * @return Lost
     */
    Lost queryById(int id);

    /**
     * 查询Lost列表
     * @return
     */
    List<Lost> queryAll();
}
