package com.xjx.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xjx.dbUtil.DbUtil;
import com.xjx.dto.User;
import com.xjx.dto.UserJson;

/**
 * Created by jiax on 2016/7/21.
 */
@WebServlet(name = "Login",value= "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        String sql = "SELECT * FROM user where user_id = '"+user_id+"' and password = '" + password +"'";

        User user = DbUtil.selectUser(sql);

        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
        UserJson userJson = new UserJson(user,user != null);
        String jsonString = JSON.toJSONString(user, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.BrowserCompatible);
        out.write(jsonString);

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
