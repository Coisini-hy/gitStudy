<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/1/13
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登陆入口</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<script>
    function enterMain() {
        location.href = "index.jsp";
    }
</script>
<body>
<section class="main">
    <div class="logo text-center">
        <h1> <a href="index.html">管理员登录</a></h1>
    </div>
    <div class="content-w3ls text-center">
        <img src="images/admin.png" alt="" class="img-responsive">
        <form  action="${pageContext.request.contextPath}/AdminLoginServlet"  method="post">
            <div class="wthree-field">
                <input type="text" name="admin_name" id="admin_name" placeholder="账号" required>
            </div>
            <div class="wthree-field">
                <input type="password" name="admin_pwd" id="admin_pwd" placeholder="密码" required>
            </div>
            <div class="wthree-field">
                <button type="submit" class="btn">登录</button>
            </div>
        </form>
    </div>
    <div class="copyright">
        <p onclick="enterMain()">返回主界面</p>
    </div>
</section>
</body>
</html>
