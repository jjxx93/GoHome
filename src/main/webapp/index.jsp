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
<form name="LoginForm" method="post" action="/youtu/login">
    <table>
        <tr>
            <td>账号：</td>
            <td><input type="text" name="user_uuid"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var baseUrl='<%=basePath%>';

        $("#login").click(function () {
            if (document.LoginForm.user_id.value == "") {
                alert("账号不能为空!");
                document.LoginForm.user_id.focus();
            } else if (document.LoginForm.password.value == "") {
                alert("密码不能为空!");
                document.LoginForm.password.focus();
            } else {
                var saveData = {user_id:"1",password:"0"};
                $.ajax({
                    url: baseUrl+'login',
                    type: 'POST',
                    //dataType: 'json',
                    aync:false,
                    contentType:"application/json",  //发送至服务器的类型
                    data: {user_id:"1",password:"0"},
                    success:function(result){
                         //debugger;
                         console.log(result);
                    }
                });
            }
        });

    });
</script>