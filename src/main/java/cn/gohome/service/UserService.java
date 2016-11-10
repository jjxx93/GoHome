package cn.gohome.service;

import cn.gohome.entity.User;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by jiax on 2016/8/23.
 */
public interface UserService {

    /**
     * 新增用户
     * @param userName
     * @param password
     * @return
     */
    User addUser(String userName, String password);

    /**
     * 修改用户头像
     *
     * @param headImg
     * @return
     */
    Boolean changeHeadImg(String userUuid, String headImg);

    /**
     * 修改密码
     * @param userUuid
     * @param oldPassword
     * @param newPassword
     * @return
     */
    Boolean changePassword(String userUuid, String oldPassword, String newPassword);

    /**
     * 改：修改用户信息
     * @param userUuid
     * @param telephone
     * @param nickName
     * @param realName
     * @param sex
     * @param birthday
     * @param city
     * @return
     */
    Boolean changeInformation(String userUuid, String telephone, String nickName, String realName,
                              String sex, String birthday, String city);

    /**
     * 验证账号密码
     * @param userName
     * @param password
     * @return
     */
    User validation(String userName, String password);

    /**
     * 验证账号密码
     * @param userUuid
     * @return
     */
    JSONObject validationUserUuid(String userUuid);

    /**
     * 查询用户名是否存在
     * @param userName
     * @return
     */
    Boolean isUserNameExisted (String userName);

    /**
     * 根据userUuid查找用户
     * @param userUuid
     * @return
     */
    User getUserByUserUuid(String userUuid);
}
