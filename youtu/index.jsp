<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>欢迎光临</title>
</head>
<body>
<center>
    <table>
        <tr>
            <td><a href="register.html">注册</a></td>
        </tr>
        <tr>
            <td><a href="login.html">登录</a></td>
        </tr>
        <tr>
            <td><a href="picture.html">图片处理</a></td>
        </tr>
        <tr>
            <td><a href="/photo/getUploadToken">获取上传token</a></td>
        </tr>
    </table>
</center>
</body>
</html>