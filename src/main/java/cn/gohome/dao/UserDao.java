package cn.gohome.dao;

import cn.gohome.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by jiax on 2016/8/23.
 */
@Repository
public interface UserDao {
    /**
     * 增：新增用户行
     * @param userName
     * @param password
     */
    void insertUser(@Param("userName") String userName, @Param("password") String password, @Param("userUuid") String userUuid);

    /**
     * 改：修改头像
     *
     * @param headImg
     */
    int updateHeadImg(@Param("userUuid") String userUuid, @Param("headImg") String headImg);

    /**
     * 改：修改密码
     * @param userUuid
     * @param oldPassword
     * @param newPassword
     * @return
     */
    int updatePassword(@Param("userUuid") String userUuid, @Param("oldPassword") String oldPassword,
                       @Param("newPassword") String newPassword);

    /**
     * 改：修改用户信息
     * @param telephone
     * @param nickName
     * @param realName
     * @param nickName
     * @param sex
     * @param birthday
     * @param city
     * @return
     */
    int updateUserInformation(@Param("userUuid") String userUuid, @Param("telephone") String telephone,
                              @Param("nickName") String nickName, @Param("realName") String realName,
                              @Param("sex") String sex, @Param("birthday") String birthday, @Param("city") String city);

    /**
     * 查：根据用户名查数据
     * @param userName
     * @return
     */
    User queryByUserName(@Param("userName")String userName);

    /**
     * 查：根据用户id查数据
     * @param userUuid
     * @return
     */
    User queryByUserUuid(@Param("userUuid")String userUuid);

    /**
     * 查：验证账号密码是否匹配
     * @param userName
     * @param password
     * @return
     */
    User queryByUserNameAndPassword(@Param("userName")String userName, @Param("password")String password);

    /**
     * 查：验证用户id和密码是否匹配
     * @param userUuid
     * @param password
     * @return
     */
    User queryByUserUuidAndPassword(@Param("userUuid")String userUuid, @Param("password")String password);
}
