package cn.gohome.common;

import cn.gohome.entity.Befounder;
import cn.gohome.entity.Loster;
import cn.gohome.entity.Status;
import cn.gohome.entity.Talks;

import java.util.List;
import java.util.TreeSet;

/**
 * Created by jiax on 2016/11/5.
 */
public class Utils {
    /**
     * 使用TreeSet对取出的数据按时间从后到前排序
     * @param losterList
     * @param befounderList
     * @param talksList
     * @return
     */
    public static TreeSet<Status> getTreeSetByUpdateTime (List<Loster> losterList, List<Befounder> befounderList,
                                                          List<Talks> talksList){
        TreeSet<Status> statusSet = new TreeSet<>();

        for (Loster loster:losterList) {
            Status status = new Status(Constants.LOSTER, loster.getUpdateTime(), loster.getLosterUuid(),
                    loster.getPicture(), loster.getRemarks(), loster.getSourceId());

//            status.setType(Constants.LOSTER);
//            status.setUpdateTime(loster.getUpdateTime());
//
//            status.setUuid(loster.getLosterUuid());
//            status.setPicture(loster.getPicture());
//            status.setRemarks(loster.getRemarks());
//            status.setUserUuid(loster.getSourceId());

            statusSet.add(status);
        }

        for (Befounder befounder:befounderList) {
            Status status = new Status(Constants.BEFOUNDER, befounder.getUpdateTime(), befounder.getUuid(),
                    befounder.getPicture(), befounder.getRemarks(), befounder.getFounderUuid());
//            status.setType(Constants.BEFOUNDER);
//            status.setUpdateTime(befounder.getUpdateTime());
//
//            status.setUuid(befounder.getUuid());
//            status.setPicture(befounder.getPicture());
//            status.setRemarks(befounder.getRemarks());
//            status.setUserUuid(befounder.getFounderUuid());

            statusSet.add(status);
        }

        for (Talks talks:talksList) {
            Status status = new Status(Constants.TALKS, talks.getUpdateTime(), talks.getUuid(),
                    talks.getPicture(), talks.getTexts(), talks.getUserUuid());
//            status.setType(Constants.TALKS);
//            status.setUpdateTime(talks.getUpdateTime());
//
//            status.setUuid(talks.getUuid());
//            status.setPicture(talks.getPicture());
//            status.setRemarks(talks.getTexts());
//            status.setUserUuid(talks.getUserUuid());

            statusSet.add(status);
        }

        return statusSet;
    }
}
