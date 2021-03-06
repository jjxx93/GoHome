package cn.gohome.common;

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
    public final static String CHANGE_HEAD_IMG_SUCCESS = "修改头像成功";
    public final static String CHANGE_HEAD_IMG_FAILURE = "修改头像失败";

    // 修改用户信息返回值
    public final static String CHANGE_INFORMATION_SUCCESS = "修改用户信息成功";
    public final static String CHANGE_INFORMATION_FAILURE = "修改用户信息成功";

    // 修改密码返回值
    public final static String CHANGE_PASSWORD_SUCCESS = "修改密码成功";
    public final static String CHANGE_PASSWORD_FAILURE = "修改密码失败";

    // 获取上传图片Token返回值
    public final static String GET_UPDATE_TOKEN_SUCCESS = "获取UPDATE_TOKEN成功";

    // 上传走失者信息
    public final static String ADD_LOSTER_SUCCESS = "上传走失者信息成功";
    public final static String ADD_LOSTER_FAIL = "上传走失者信息失败";

    // 查询走失者信息
    public final static String GET_LOSTER_SUCCESS = "查询走失者信息成功";
    public final static String GET_LOSTER_FAIL = "未查询到走失者信息";

    // 查询走失者列表信息
    public final static String GET_LOSTER_LIST_SUCCESS = "查询走失者列表信息成功";
    public final static String GET_LOSTER_LIST_FAIL = "查询走失者列表信息失败";

    // 修改走失者信息
    public final static String MODIFY_LOSTER_SUCCESS = "修改走失者信息成功";
    public final static String MODIFY_LOSTER_FAIL = "修改走失者信息失败";

    // 删除走失者信息
    public final static String DELETE_LOSTER_SUCCESS = "删除走失者信息成功";
    public final static String DELETE_LOSTER_FAIL = "删除走失者信息失败";

    // 上传疑似走失者信息
    public final static String ADD_BEFOUNDER_SUCCESS = "上传疑似走失者信息成功";
    public final static String ADD_BEFOUNDER_FAIL = "上传疑似走失者信息失败";

    // 获取疑似走失者信息
    public final static String GET_BEFOUNDER_SUCCESS = "获取疑似走失者信息成功";
    public final static String GET_BEFOUNDER_FAIL = "无疑似走失者信息";

    // 修改疑似走失者照片信息
    public final static String MODIFY_BEFOUNDER_SUCCESS = "修改疑似走失者照片信息成功";
    public final static String MODIFY_BEFOUNDER_FAIL = "修改疑似走失者照片信息失败";
    public final static String MODIFY_BEFOUNDER_NOPHOTO = "无此疑似走失者照片";

    // 删除疑似走失者信息
    public final static String DELETE_BEFOUNDER_SUCCESS = "删除疑似走失者信息成功";
    public final static String DELETE_BEFOUNDER_FAIL = "删除疑似走失者信息失败";

    // 分析疑似走失者照片
    public final static String DETECT_BEFOUNDER_SUCCESS = "分析疑似走失者照片成功";
    public final static String DETECT_BEFOUNDER_FAIL = "分析疑似走失者照片失败";
    public final static String DETECT_BEFOUNDER_NOPHOTO = "无此疑似走失者照片";

    // 匹配疑似走失者照片
    public final static String MATCH_BEFOUNDER_SUCCESS = "匹配疑似走失者照片成功";
    public final static String MATCH_BEFOUNDER_FAIL = "匹配疑似走失者照片失败";
    public final static String MATCH_BEFOUNDER_NOTFACE = "上传的图片内未检测到人脸";
    public final static String MATCH_BEFOUNDER_NOPHOTO = "无此疑似走失者信息";
    public final static String MATCH_BEFOUNDER_NODETECT = "此走失者信息未经过分析";
    public final static String MATCH_BEFOUNDER_NOLOSTER = "数据库中无相匹配数据";
    public final static String MATCH_BEFOUNDER_NOGOODLOSTER = "数据库中无相似度大于50的匹配信息";

    // 获取匹配表信息
    public final static String GET_MATCCHES_SUCCESS = "获取匹配信息成功";
    public final static String GET_MATCHES_FAIL = "无匹配信息";

    // 新增talks
    public final static String ADD_TALKS_SUCCESS = "插入Talks数据成功";
    public final static String ADD_TALKS_FAIL = "插入Talks数据失败";

    // 删除talks
    public final static String DELETE_TALKS_SUCCESS = "删除Talks成功";
    public final static String DELETE_TALKS_FAIL = "删除Talks失败";

    // 修改talks
    public final static String MODIFY_TALKS_SUCCESS = "修改Talks成功";
    public final static String MODIFY_TALKS_FAIL = "修改Talks失败";

    // 查找talks
    public final static String GET_TALKS_SUCCESS = "查找Talks成功";
    public final static String GET_TALKS_FAIL = "查找Talks失败";

    // 查找新状态消息
    public final static String GET_STATUS_SUCCESS = "查找新状态成功";
    public final static String GET_STATUS_FAIL = "查找新状态失败";

    // 上传Report
    public final static String ADD_REPORT_SUCCESS = "上传举报成功";
    public final static String ADD_REPORT_FAILURE = "上传举报失败";

    // 查找Report
    public final static String GET_REPORT_SUCCESS = "查找到举报数据";
    public final static String GET_REPORT_FAILURE = "查找不到举报数据";
}
