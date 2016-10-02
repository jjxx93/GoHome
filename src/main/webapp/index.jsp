<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="https://assets-cdn.github.com/favicon.ico">
    <base href="<%=basePath%>">
    <title>欢迎光临</title>
</head>
<body>
<center>
<table>
    <tr><td><a href="register.html">注册</a></td></tr>
    <tr><td><a href="login.html">登录</a></td></tr>
    <tr>
        <td><a href="picture.html">上传图片</a></td>
    </tr>
    <tr>
        <td><a href="/photo/getUploadToken">获取上传图片Token</a></td>
    </tr>
    <tr>
        <td><a href="uploadLoster.html">上传走失者信息</a></td>
    </tr>
</table>
</center>
</body>
</html>