package cn.gohome.service;

import cn.gohome.dao.UserDao;
import cn.gohome.dao.UserDaoTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by jiax on 2016/8/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class UserServiceTest {
    @Resource
    private UserDao userDao;

    @Resource
    private UserService userService;

    @Test
    public void validation() throws Exception {
        UserDaoTest test = new UserDaoTest();
        test.validation();
    }

    @Test
    public void addUserNameAndPassword() throws Exception {

    }

    @Test
    public void validationUserUuid() throws Exception {
        System.out.println(userService.validationUserUuid("1"));
    }

    @Test
    public void isUserNameExisted() throws Exception {

    }

    @Test
    public void changeHeadImg() throws Exception {
        String headImgUrl = "http://odqvl1oxn.bkt.clouddn.com/2.jpg";
        System.out.println(userService.changeHeadImg("2f667d326b7041feac4e2ccf57fc4c84", headImgUrl));
    }

}