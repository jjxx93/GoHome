package com.youtu.service.impl;

import com.youtu.dao.LostDao;
import com.youtu.entity.Lost;
import com.youtu.service.LostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiax on 2016/8/22.
 */
@Service
public class LostServiceImpl implements LostService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //注入Service依赖
    @Autowired      //自动注入
    private LostDao lostDao;

    @Override
    public Lost getById(int id) {
        return lostDao.queryById(id);
    }

    @Override
    public List<Lost> getLostList() {
        return lostDao.queryAll();
    }
}
