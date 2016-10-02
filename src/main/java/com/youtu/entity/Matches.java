package com.youtu.entity;

/**
 * Created by jiax on 2016/10/2.
 */
public class Matches {
    private int id;
    private String befounderUuid;
    private String losterUuid;
    private int similarity;
    private int status;

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", befounderUuid='" + befounderUuid + '\'' +
                ", losterUuid='" + losterUuid + '\'' +
                ", similarity=" + similarity +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBefounderUuid() {
        return befounderUuid;
    }

    public void setBefounderUuid(String befounderUuid) {
        this.befounderUuid = befounderUuid;
    }

    public String getLosterUuid() {
        return losterUuid;
    }

    public void setLosterUuid(String losterUuid) {
        this.losterUuid = losterUuid;
    }

    public int getSimilarity() {
        return similarity;
    }

    public void setSimilarity(int similarity) {
        this.similarity = similarity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
