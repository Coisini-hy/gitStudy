<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/1/13
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;500;700&display=swap" rel="stylesheet">
  </head>
  <script>
    function enterUsers() {
      location.href = "usersLogin.jsp";
    }
    function enterAdmin() {
      location.href = "adminLogin.jsp";
    }
  </script>
  <body>

  <section class="main">
    <div class="logo text-center">
      <h1> <a href="#">欢迎来到电影管理系统</a></h1>
    </div>
    <div class="content-w3ls text-center">
      <div class="wthree-field">
        <button class="btn"  onclick="enterUsers()">用户登录入口</button>
      </div>
      <div class="wthree-field">
        <button class="btn"   onclick="enterAdmin()">管理员登录入口</button>
      </div>
    </div>
  </section>
  </body>
</html>
