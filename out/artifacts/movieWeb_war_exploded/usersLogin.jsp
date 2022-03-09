<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/1/13
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="//fonts.googleapis.com/css2?family=Kumbh+Sans:wght@300;400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style1.css" type="text/css" media="all" />
</head>
<script>
    function enterMain() {
        location.href = "index.jsp";
    }
    function enterReg() {
        location.href = "usersReg.jsp";
    }
</script>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String username = "";
    String password = "";
    Cookie[] cookies = request.getCookies();
    if(cookies != null && cookies.length > 0) {
        for(Cookie c:cookies) {
            if(c.getName().equals("usernameCookie")) {
                // 解码
                username = URLDecoder.decode(c.getValue(), "utf-8");
            } else if(c.getName().equals("passwordCookie")) {
                password = URLDecoder.decode(c.getValue(), "utf-8");
            }
        }

    }
%>
<div class="signInform">
    <div class="container">
        <div class="w3l-form-info">
            <div class="w3_info">
                <h2>登录</h2>
                <form action="${pageContext.request.contextPath}/UsersLoginServlet"  method="post">
                    <div class="input-group">
                        <span><i class="fas fa-user" aria-hidden="true"></i></span>
                        <input type="text" name="user_name" placeholder="用户名" value = "<%=username%>" required>
                    </div>
                    <div class="input-group">
                        <span><i class="fas fa-key" aria-hidden="true"></i></span>
                        <input type="password" name="user_pwd" placeholder="密码" value = "<%=password%>" required>
                    </div>
                    <div class="form-row bottom">
                        <div class="form-check">
                            <input type="checkbox" id="remenber" name = "isChecked" checked="checked" >
                            <label for="remenber" > Remember me?</label>
                        </div>
                        <a href="#url" class="forgot">Forgot password?</a>
                    </div>
                    <button class="btn btn-primary btn-block" type="submit">登录</button>
                </form>
                <button class="btn btn-primary btn-block" onclick="enterReg()">注册</button>
                <p class="continue"><span onclick="enterMain()">返回主界面</span></p>
            </div>
        </div>
    </div>
</div>
<script src="js/fontawesome.js"></script>
</body>
</html>
