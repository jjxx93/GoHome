package cn.gohome.entity;

/**
 * Created by jiax on 2016/8/23.
 */

public class User {
    private String id;
    private String userUuid;
    private String userName;
    private String password;
    private String telephone;
    private String code;
    private String codeCreateTime;
    private String headImg;
    private String nickName;
    private String realName;
    private int sex;
    private String birthday;
    private String examineState;
    private String forbiddenTime;
    private String city;
    private String lastLoginTime;
    private String jpushId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeCreateTime() {
        return codeCreateTime;
    }

    public void setCodeCreateTime(String codeCreateTime) {
        this.codeCreateTime = codeCreateTime;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getExamineState() {
        return examineState;
    }

    public void setExamineState(String examineState) {
        this.examineState = examineState;
    }

    public String getForbiddenTime() {
        return forbiddenTime;
    }

    public void setForbiddenTime(String forbiddenTime) {
        this.forbiddenTime = forbiddenTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getJpushId() {
        return jpushId;
    }

    public void setJpushId(String jpushId) {
        this.jpushId = jpushId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userUuid='" + userUuid + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", code='" + code + '\'' +
                ", codeCreateTime='" + codeCreateTime + '\'' +
                ", headImg='" + headImg + '\'' +
                ", nickName='" + nickName + '\'' +
                ", realName='" + realName + '\'' +
                ", sex=" + sex +
                ", birthday='" + birthday + '\'' +
                ", examineState='" + examineState + '\'' +
                ", forbiddenTime='" + forbiddenTime + '\'' +
                ", city='" + city + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", jpushId='" + jpushId + '\'' +
                '}';
    }
}
