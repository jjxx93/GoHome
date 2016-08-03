package com.xjx.dbUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xjx.dto.User;
import com.xjx.dto.UserJson;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiax on 2016/7/21.
 */
public class DbUtilTest {
    @Test
    public void selectInt() throws Exception {
        String sql = "SELECT count(id) FROM user where id = '1001' and password = '1'";

        System.out.println(DbUtil.selectInt(sql));
    }

    @Test
    public void selectUser() throws Exception {
        String sql = "SELECT * FROM user where user_id = '1001' and password = '1'";

        User user = DbUtil.selectUser(sql);


        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
        UserJson userJson = new UserJson(user,user != null);
        String jsonString = JSON.toJSONString(userJson, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.BrowserCompatible);
        System.out.println(jsonString);
//        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
//        String jsonString = JSON.toJSONString(user, SerializerFeature.WriteDateUseDateFormat);
//
//        //JSON.toJSONString(user);
//        System.out.println(jsonString);
    }
}