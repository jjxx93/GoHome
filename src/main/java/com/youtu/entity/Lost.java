package com.youtu.entity;

/**
 * Created by jiax on 2016/8/22.
 */
public class Lost {
    private int id;
    private String lostUuid;

    public int getId() {
        return id;
    }

    public String getLostUuid() {
        return lostUuid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLostUuid(String lostUuid) {
        this.lostUuid = lostUuid;
    }

    @Override
    public String toString() {
        return "Lost{" +
                "id=" + id +
                ", lostUuid=" + lostUuid +
                '}';
    }
}
