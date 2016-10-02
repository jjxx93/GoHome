package com.youtu.common;

/**
 * Created by jiax on 2016/9/28.
 */
public class Msgs {
    // 用户状态
    public static final String USER_NORMAL = "账号状态正常";
    public static final String USER_DISABLE = "该账号被禁用";
    public static final String USER_NOT_EXIST = "该账号不存在";

    // 注册返回值
    public final static String REGISTE_SUCCESS = "注册成功";
    public final static String REGISTE_FAILURE = "注册失败";
    public final static String REGISTE_USERNAME_EXIST = "该用户名已存在";
    public final static String REGISTE_EMAIL_EXIST = "该邮箱已注册";

    // 登录返回值
    public final static String LOGIN_SUCCESS = "登录成功";
    public final static String LOGIN_PASSWORD_ERROR = "用户名或密码错误";
    public final static String LOGIN_VALIDATECODE_ERROR = "验证码错误";

    // 改头像返回值
    public final static String CHANGE_HEAD_IMG_SUCCESS = "修改成功";
    public final static String CHANGE_HEAD_IMG_FAILURE = "修改失败";

    // 获取上传图片Token返回值
    public final static String GET_UPDATE_TOKEN_SUCCESS = "获取成功";

    // 上传走失者信息
    public final static String ADD_LOSTER_SUCCESS = "上传走失者信息成功";
    public final static String ADD_LOSTER_FAIL = "上传走失者信息失败";
}
