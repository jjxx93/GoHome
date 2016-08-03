package com.xjx.dbUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xjx.dto.User;

import java.sql.*;

/**
 * Created by jiax on 2016/7/21.
 */
public class DbUtil {
    public static int selectInt(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtu?user=root&password=1226");
            PreparedStatement pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pstmt.executeQuery()
        ) {
            rs.first();
            return rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static User selectUser(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtu?user=root&password=1226");
                PreparedStatement pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = pstmt.executeQuery()
        ) {
            rs.first();

            int user_id = rs.getInt("user_id");
            String name = rs.getString("name");
            int degree = rs.getInt("degree");
            Timestamp createTime = rs.getTimestamp("create_time");
            return new User(user_id,name,degree,createTime);
//            JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
//            String jsonString = JSON.toJSONString(user, SerializerFeature.WriteDateUseDateFormat);
//            return jsonString;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
