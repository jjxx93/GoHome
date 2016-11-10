package cn.gohome.service.impl;

import cn.gohome.common.Utils;
import cn.gohome.dao.BefounderDao;
import cn.gohome.dao.LosterDao;
import cn.gohome.dao.TalksDao;
import cn.gohome.dao.UserDao;
import cn.gohome.entity.*;
import cn.gohome.service.CommonService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeSet;

/**
 * Created by jiax on 2016/11/3.
 */
@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private LosterDao losterDao;

    @Autowired
    private BefounderDao befounderDao;

    @Autowired
    private TalksDao talksDao;

    @Autowired
    private UserDao userDao;

    @Override
    public JSONArray getList(int rows) {
        JSONArray jsonArray = new JSONArray();

        // 从三张表中取数据
        List<Loster> losterList = losterDao.queryLosterList(rows);
        List<Befounder> befounderList = befounderDao.queryBefounderList(rows);
        List<Talks> talksList = talksDao.queryTalks(rows);

        // 使用TreeSet对取出的数据按时间从后到前排序
        TreeSet<Status> statusSet = Utils.getTreeSetByUpdateTime(losterList, befounderList, talksList);

        // 将TreeSet数据导出rows条到jsonArray
        int statusSetSize = statusSet.size();
        for (int i = 0; i < statusSetSize && i < rows; i++) {
            Status status = statusSet.pollFirst();
            User user = userDao.queryByUserUuid(status.getUserUuid());  // 添加user数据
            status.setUserNickName(user.getNickName());
            status.setUserHeadImg(user.getHeadImg());

            jsonArray.add(status);
        }

        return jsonArray;
    }

    @Override
    public JSONArray getList(String latestTime, int rows) {
        JSONArray jsonArray = new JSONArray();

        // 从三张表中取数据
        List<Loster> losterList = losterDao.queryLosterListAfterUpdateTime(latestTime, rows);
        List<Befounder> befounderList = befounderDao.queryBefounderListAfterUpdateTime(latestTime, rows);
        List<Talks> talksList = talksDao.queryTalksAfterUpdateTime(latestTime, rows);

        // 使用TreeSet对取出的数据按时间从后到前排序
        TreeSet<Status> statusSet = Utils.getTreeSetByUpdateTime(losterList, befounderList, talksList);

        // 将TreeSet数据导出rows条到jsonArray
        int statusSetSize = statusSet.size();
        for (int i = 0; i < statusSetSize && i < rows; i++) {
            Status status = statusSet.pollFirst();
            User user = userDao.queryByUserUuid(status.getUserUuid());  // 添加user数据
            status.setUserNickName(user.getNickName());
            status.setUserHeadImg(user.getHeadImg());

            jsonArray.add(status);
        }

        return jsonArray;
    }

    @Override
    public JSONArray getList(int rows, String earliestTime) {
        JSONArray jsonArray = new JSONArray();

        // 从三张表中取数据
        List<Loster> losterList = losterDao.queryLosterListBeforeUpdateTime(earliestTime, rows);
        List<Befounder> befounderList = befounderDao.queryBefounderListBeforeUpdateTime(earliestTime, rows);
        List<Talks> talksList = talksDao.queryTalksBeforeUpdateTime(earliestTime, rows);

        // 使用TreeSet对取出的数据按时间从后到前排序
        TreeSet<Status> statusSet = Utils.getTreeSetByUpdateTime(losterList, befounderList, talksList);

        // 将TreeSet数据导出rows条到jsonArray
        int statusSetSize = statusSet.size();
        for (int i = 0; i < statusSetSize && i < rows; i++) {
            Status status = statusSet.pollFirst();
            User user = userDao.queryByUserUuid(status.getUserUuid());  // 添加user数据
            status.setUserNickName(user.getNickName());
            status.setUserHeadImg(user.getHeadImg());

            jsonArray.add(status);
        }

        return jsonArray;
    }
}
