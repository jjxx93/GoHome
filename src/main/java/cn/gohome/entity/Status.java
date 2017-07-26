package cn.gohome.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 记录新状态信息
 * Created by jiax on 2016/11/3.
 */
public class Status implements Comparable{
    private int type;               // 消息类型, 0——Loster、1——Befounder、2——Talks
    private String updateTime;      // 更新时间

    private String uuid;            // 消息uuid
    private String picture;         // 图片链接
    private String remarks;         // 备注

    private String userUuid;        // 用户uuid
    private String userNickName;    // 用户昵称
    private String userHeadImg;     // 用户头像

    public Status() {
    }

    public Status(int type, String updateTime, String uuid, String picture, String remarks,
                  String userUuid, String userNickName, String userHeadImg) {
        this.type = type;
        this.updateTime = updateTime;
        this.uuid = uuid;
        this.picture = picture;
        this.remarks = remarks;
        this.userUuid = userUuid;
        this.userNickName = userNickName;
        this.userHeadImg = userHeadImg;
    }

    public Status(int type, String updateTime, String uuid, String picture, String remarks,
                  String userUuid) {
        this.type = type;
        this.updateTime = updateTime;
        this.uuid = uuid;
        this.picture = picture;
        this.remarks = remarks;
        this.userUuid = userUuid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }


    @Override
    public int compareTo(Object o) {
        Status status = (Status) o;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            Date date1 =sdf.parse(this.updateTime);
            Date date2 =sdf.parse(status.updateTime);
            return date2.compareTo(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }
}


