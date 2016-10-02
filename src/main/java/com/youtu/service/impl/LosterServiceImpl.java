package com.youtu.service.impl;

import com.youtu.common.GetUUIDNumber;
import com.youtu.dao.LosterDao;
import com.youtu.service.LosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
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

    @Override
    public boolean addLoster(String losterName, String losterBirthday, String gender, int height, String lostDate,
                             String picture, String lostLocation, String characteristic) {
        String losterUuid = GetUUIDNumber.createUUIDNumber();
        int age = Calendar.getInstance().get(Calendar.YEAR) - Integer.valueOf(losterBirthday.substring(0, 4)) + 1;
        Character genderChar = '0';
        if (gender.equals("女")) {
            genderChar = '1';
        }
        Character datasource = '5';
        if (losterDao.insertLoster(losterUuid, losterName, age, losterBirthday, genderChar, height, lostDate,
                picture, lostLocation, characteristic, datasource) > 0) {
            return true;
        }
        return false;
    }
}
