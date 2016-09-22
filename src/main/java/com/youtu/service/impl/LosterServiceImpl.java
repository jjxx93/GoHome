package com.youtu.service.impl;

import com.youtu.dao.LosterDao;
import com.youtu.service.LosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiax on 2016/9/21.
 */
@Service
public class LosterServiceImpl implements LosterService {
    @Autowired      //自动注入
    private LosterDao losterDao;

    @Override
    public List<String> getUrl(int age, int gender) {
        return losterDao.queryByAgeAndGender(age, String.valueOf(gender));
    }

    @Override
    public List<String> getUrl(int minAge, int maxAge, int gender) {
        return losterDao.queryByMaxMinAgeAndGender(minAge, maxAge, String.valueOf(gender));
    }
}
