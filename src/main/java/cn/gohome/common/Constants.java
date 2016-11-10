package cn.gohome.common;

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
    public static final int USER_NORMAL = 10;
    public static final int USER_DISABLE = 11;
    public static final int USER_NOT_EXIST = 12;

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

    // 修改密码返回值
    public final static int CHANGE_PASSWORD_SUCCESS = 0;
    public final static int CHANGE_PASSWORD_FAILURE = 1;

    // 修改用户信息返回值
    public final static int CHANGE_INFORMATION_SUCCESS = 0;
    public final static int CHANGE_INFORMATION_FAILURE = 1;

    // 获取上传图片Token返回值
    public final static int GET_UPDATE_TOKEN_SUCCESS = 0;

    // 上传走失者信息
    public final static int ADD_LOSTER_SUCCESS = 0;
    public final static int ADD_LOSTER_FAIL = 1;

    // 查询走失者信息
    public final static int GET_LOSTER_SUCCESS = 0;
    public final static int GET_LOSTER_FAIL = 1;

    // 查询走失者列表信息
    public final static int GET_LOSTER_LIST_SUCCESS = 0;
    public final static int GET_LOSTER_LIST_FAIL = 1;

    // 修改走失者信息
    public final static int MODIFY_LOSTER_SUCCESS = 0;
    public final static int MODIFY_LOSTER_FAIL = 1;

    // 删除走失者信息
    public final static int DELETE_LOSTER_SUCCESS = 0;
    public final static int DELETE_LOSTER_FAIL = 1;

    // 上传疑似走失者信息
    public final static int ADD_BEFOUNDER_SUCCESS = 0;
    public final static int ADD_BEFOUNDER_FAIL = 1;

    // 获取疑似走失者信息
    public final static int GET_BEFOUNDER_SUCCESS = 0;
    public final static int GET_BEFOUNDER_FAIL = 1;

    // 修改疑似走失者照片信息
    public final static int MODIFY_BEFOUNDER_SUCCESS = 0;
    public final static int MODIFY_BEFOUNDER_FAIL = 1;
    public final static int MODIFY_BEFOUNDER_NOPHOTO = 2;

    // 删除疑似走失者信息
    public final static int DELETE_BEFOUNDER_SUCCESS = 0;
    public final static int DELETE_BEFOUNDER_FAIL = 1;

    // 分析疑似走失者照片
    public final static int DETECT_BEFOUNDER_SUCCESS = 0;
    public final static int DETECT_BEFOUNDER_FAIL = 1;
    public final static int DETECT_BEFOUNDER_NOPHOTO = 2;

    // 匹配疑似走失者照片
    public final static int MATCH_BEFOUNDER_SUCCESS = 0;
    public final static int MATCH_BEFOUNDER_FAIL = 1;
    public final static int MATCH_BEFOUNDER_NOTFACE = 2;
    public final static int MATCH_BEFOUNDER_NOPHOTO = 3;
    public final static int MATCH_BEFOUNDER_NODETECT = 4;
    public final static int MATCH_BEFOUNDER_NOLOSTER = 5;
    public final static int MATCH_BEFOUNDER_NOGOODLOSTER = 6;

    // 获取匹配表信息
    public final static int GET_MATCCHES_SUCCESS = 0;
    public final static int GET_MATCHES_FAIL = 1;

    // 新增talks
    public final static int ADD_TALKS_SUCCESS = 0;
    public final static int ADD_TALKS_FAIL = 1;

    // 删除talks
    public final static int DELETE_TALKS_SUCCESS = 0;
    public final static int DELETE_TALKS_FAIL = 1;

    // 修改talks
    public final static int MODIFY_TALKS_SUCCESS = 0;
    public final static int MODIFY_TALKS_FAIL = 1;

    // 查找talks
    public final static int GET_TALKS_SUCCESS = 0;
    public final static int GET_TALKS_FAIL = 1;

    // 查找新状态消息
    public final static int GET_STATUS_SUCCESS = 0;
    public final static int GET_STATUS_FAIL = 1;

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
    public static String Qiniu_Youtu_Upload_Token = "NrZVEweKI24oovDg2o1gjpr8zAuwDGo8mBsbfVOf:2YxWDF8aMP1nrTEKdYhxhCD4A6U=:eyJzY29wZSI6InlvdXR1IiwiZGVhZGxpbmUiOjUwNzUxMzYyOTZ9";

    // 走失者数据来源
    public final static int BAO_BEI_HUI_JIA = 0;
    public final static int WAITING_FOR_ME = 1;
    public final static int USER = 5;

    // Status Type
    public final static int LOSTER = 0;
    public final static int BEFOUNDER = 1;
    public final static int TALKS = 2;
}
