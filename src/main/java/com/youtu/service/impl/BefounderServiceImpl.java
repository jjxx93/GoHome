package com.youtu.service.impl;

import com.youtu.common.GetUUIDNumber;
import com.youtu.dao.BefounderDao;
import com.youtu.entity.Befounder;
import com.youtu.service.BefounderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiax on 2016/10/2.
 */
@Service
public class BefounderServiceImpl implements BefounderService {
    @Autowired      //自动注入
    private BefounderDao befounderDao;

    @Override
    public Boolean addBefounder(String founderUuid, String foundLocation, String foundTime, String picture, String state) {
        String uuid = GetUUIDNumber.createUUIDNumber();
        if (befounderDao.insertBefounder(uuid, founderUuid, foundLocation, foundTime, picture, state) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Befounder> getBefounder(String founderUuid) {
        return befounderDao.queryByFounderUuid(founderUuid);
    }
}
