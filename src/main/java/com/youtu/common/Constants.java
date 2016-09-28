package com.youtu.common;

/**
 * Created by jiax on 2016/9/19.
 */
public class Constants {
    //常量
    public final static int ZERO = 0;
    public final static int ONE = 1;
    public final static int TWO = 2;
    public final static int THREE = 3;
    public final static int FOUR = 4;
    public final static int FIVE = 5;
    public final static int SIX = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE = 9;

    // 用户状态
    public static final int USER_NORMAL = 0;
    public static final int USER_DISABLE = 1;
    public static final int USER_NOT_EXIST = 2;

    // 注册返回值
    public final static int REGISTE_SUCCESS = 0;
    public final static int REGISTE_FAILURE = 1;
    public final static int REGISTE_USERNAME_EXIST = 2;
    public final static int REGISTE_EMAIL_EXIST = 3;

    // 登录返回值
    public final static int LOGIN_SUCCESS = 0;
    public final static int LOGIN_PASSWORD_ERROR = 1;
    public final static int LOGIN_VALIDATECODE_ERROR = 2;

    // 改头像返回值
    public final static int CHANGE_HEAD_IMG_SUCCESS = 0;
    public final static int CHANGE_HEAD_IMG_FAILURE = 1;

    // 优图账号信息
    public static final String APP_ID = "10034230";
    public static final String SECRET_ID = "AKIDcwnh2zRMOmTg8ZGLngGRUwxaimYKtKwV";
    public static final String SECRET_KEY = "bh51AmmmnQpv72tYQK0YEH5YemQTxUUA";
    public static final String USER_ID = "971247228";

    // Face++账号信息
    public static final String API_Key = "582834e7e818df89f4078877ef892edd";
    public static final String API_Secret = "I1ErzPdGeY3jC7kL-14VTl0-sz4dTF0C";

    // 七牛账号信息
    public static final String Qiniu_ACCESS_KEY = "NrZVEweKI24oovDg2o1gjpr8zAuwDGo8mBsbfVOf";
    public static final String Qiniu_SECRET_KEY = "rZMwav3DMV7wZcH2xtr2qyxQSphYn5UIHZ__JVbU";
    public static String Qiniu_Youtu_Upload_Token = "NrZVEweKI24oovDg2o1gjpr8zAuwDGo8mBsbfVOf:fSUg2nmKR06Md_Tn1RnVSPwSL2c=:eyJzY29wZSI6InlvdXR1IiwiZGVhZGxpbmUiOjE0NzUwNjk2ODR9";
}
