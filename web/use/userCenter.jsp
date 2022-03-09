<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/1/16
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    #bar{
        width: 100%;
        height: 50px;
        position: sticky;
        display: flex;
        flex-direction: row;
        justify-content: flex-end;
    }
    #bar p{
        margin: 0 20px 0 0;
        padding: 0;
        font-size: 28px;
    }
    #bar a{
        text-decoration: none;
        margin: 0 20px 0 20px;
        color: deepskyblue;
    }
</style>
<head>
    <title>个人中心</title>
</head>
<style>
    #info{
        width: 100%;
        text-align: center;
    }
    #info input{
        width: 400px;
        height: 40px;
        font-size: 26px;
        border: 3px #879487 solid;
        border-radius: 8px;
        text-align: center;
    }
    #info label{
        font-size: 24px;
    }
    button{
        width: 470px;
        height: 50px;
        background-color: #1ac01a;
        color: whitesmoke;
        font-size: 20px;
        border: 0;
        border-radius: 10px;
    }
    button:hover{
        background-color: #0b960b;
    }
    button a{
        text-decoration: none;
        color: white;
    }
    #bt{
        display: flex;
        justify-content: center;
        margin-top: 60px;
    }
    .son{
        margin: 5px;
    }
</style>
<body>
<div id="bar">
    <p>欢迎<a href="/use/success.jsp">${user.user_name}</a>登录</p>
</div>

<div id="info">
    <h1>个人信息展示</h1>
    <div class="son">
        <label for="user_name">姓名：</label><input type="text" value="${sessionScope.user.user_name}" name="user_name" id="user_name" disabled><br>
    </div>
    <div class="son">
        <label for="user_pwd">密码：</label><input type="password" value="${sessionScope.user.user_pwd}" name="user_pwd" id="user_pwd" disabled><br>
    </div>
    <div class="son">
        <label for="user_sex">性别：</label><input type="text" value="${sessionScope.user.user_sex}" name="user_sex" id="user_sex" disabled><br>
    </div>
    <div class="son">
        <label for="user_phone">电话：</label><input type="text" value="${sessionScope.user.user_phone}" name="user_phone" id="user_phone" disabled><br>
    </div>
    <div class="son">
        <label for="user_type">类型：</label><input type="text" value="${sessionScope.user.user_type}" name="user_type" id="user_type" disabled><br>
    </div>
    <div class="son">
        <label for="user_path">路径：</label><input type="text" value="${sessionScope.user.user_path}" name="user_path" id="user_path" disabled><br>
    </div>
</div>
<div id="bt">
    <button><a href="${pageContext.request.contextPath}/UsersIdServlet?id=${user.user_id}">修改个人信息</a></button>
</div>


</body>
</html>
