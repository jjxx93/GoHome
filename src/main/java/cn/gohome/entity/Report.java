package cn.gohome.entity;

/**
 * Created by jiax on 2016/11/10.
 */
public class Report {
    private int id;                 // id
    private String uuid;            // 举报uuid
    private String aimType;      // 举报目标类型（0走失者，1疑似走失者，2说说）
    private String aimUuid;         // 目标uuid
    private int fakeNum;            // 虚假信息举报数量
    private int illegalNum;         // 违法信息举报数量
    private int harmfulNum;         // 有害信息举报数量
    private int trashyNum;          // 垃圾营销举报数量
    private String status;       // 举报状态（0待处理，1已处理）

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", aimType=" + aimType +
                ", aimUuid='" + aimUuid + '\'' +
                ", fakeNum=" + fakeNum +
                ", illegalNum=" + illegalNum +
                ", harmfulNum=" + harmfulNum +
                ", trashyNum=" + trashyNum +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAimType() {
        return aimType;
    }

    public void setAimType(String aimType) {
        this.aimType = aimType;
    }

    public String getAimUuid() {
        return aimUuid;
    }

    public void setAimUuid(String aimUuid) {
        this.aimUuid = aimUuid;
    }

    public int getFakeNum() {
        return fakeNum;
    }

    public void setFakeNum(int fakeNum) {
        this.fakeNum = fakeNum;
    }

    public int getIllegalNum() {
        return illegalNum;
    }

    public void setIllegalNum(int illegalNum) {
        this.illegalNum = illegalNum;
    }

    public int getHarmfulNum() {
        return harmfulNum;
    }

    public void setHarmfulNum(int harmfulNum) {
        this.harmfulNum = harmfulNum;
    }

    public int getTrashyNum() {
        return trashyNum;
    }

    public void setTrashyNum(int trashyNum) {
        this.trashyNum = trashyNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
