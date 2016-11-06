package cn.gohome.service.impl;

import cn.gohome.dao.TalksDao;
import cn.gohome.entity.Talks;
import cn.gohome.service.TalksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiax on 2016/10/28.
 */
@Service
public class TalksServiceImpl implements TalksService {
    @Autowired
    private TalksDao talksDao;

    @Override
    public Boolean addTalks(Talks talks) {
        if (talksDao.insertTalks(talks) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteTalks(String userUuid, String articleUuid) {
        if (talksDao.deleteTalks(userUuid, articleUuid) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean modifyTalks(Talks talks) {
        if (talksDao.updateTalks(talks) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Talks getTalksByUuid(String uuid) {
        return talksDao.queryTalksByUuid(uuid);
    }

    @Override
    public List<Talks> getTalksByUserUuid(String userUuid) {
        return talksDao.queryTalksByUserUuid(userUuid);
    }

    @Override
    public List<Talks> getTalks(int rows) {
        return talksDao.queryTalks(rows);
    }

    @Override
    public List<Talks> getTalks(int rows, String updateTime) {
        return talksDao.queryTalksBeforeUpdateTime(updateTime, rows);
    }
}
