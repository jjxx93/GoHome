package cn.gohome.service.impl;

import cn.gohome.common.GetUUIDNumber;
import cn.gohome.entity.Matches;
import cn.gohome.service.MatchesService;
import cn.gohome.dao.MatchesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiax on 2016/10/2.
 */
@Service
public class MatchesServiceImpl implements MatchesService {
    @Autowired      //自动注入
    private MatchesDao matchesDao;

    @Override
    public boolean addMatches(String userUuid, String befounderUuid, String losterUuid, int similarity, String state) {
        String uuid = GetUUIDNumber.createUUIDNumber();
        if (matchesDao.insertMatches(uuid, userUuid, befounderUuid, losterUuid, similarity, state) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Matches> getMatchesList(String userUuid, String befounderUuid) {
        return matchesDao.queryByUserUuidBefounderUuid(userUuid, befounderUuid);
    }
}
