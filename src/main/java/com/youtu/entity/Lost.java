package com.youtu.entity;

/**
 * Created by jiax on 2016/8/22.
 */
public class Lost {
    private int id;
    private int lost_uuid;

    public int getId() {
        return id;
    }

    public int getLost_uuid() {
        return lost_uuid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLost_uuid(int lost_uuid) {
        this.lost_uuid = lost_uuid;
    }

    @Override
    public String toString() {
        return "Lost{" +
                "id=" + id +
                ", lost_uuid=" + lost_uuid +
                '}';
    }
}
