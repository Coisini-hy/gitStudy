<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/1/13
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>

</head>
<style>
    #content{
        display: flex;
        flex-direction: column;
        justify-content: center;
        flex-wrap: wrap;
        align-items: center;
    }
    #content input[type="text"],
    #content input[type="password"]{
        width: 400px;
        height: 40px;
        font-size: 26px;
        border: 3px #879487 solid;
        border-radius: 8px;
        text-align: center;
    }
    #content label{
        font-size: 24px;
    }
    .son{
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        margin: 5px;
    }
    .son1{
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .son1 input[type="submit"]{
        margin-top: 30px;
        width: 480px;
        height: 50px;
        border: 0;
        border-radius: 12px;
        font-size: 20px;
        background-color: #1ac01a;
        color: whitesmoke;
        letter-spacing: 20px;
    }
    .son1 input[type="submit"]:hover{
        background-color: #0b960b;
    }
    #btn {
        display: flex;
        justify-content: flex-start;
    }

    #btn a {
        text-decoration: none;
        font-size: 20px;
        padding: 20px 0 0 50px;
        color: black;
    }
    #return {
        text-align: left;
    }
</style>
<body>
<div id="btn">
    <a href="usersLogin.jsp" id="return">返回上页</a>
</div>
<div id="content">
    <h1>用户注册页面</h1>
    <form action="${pageContext.request.contextPath}/UsersRegServlet" method="post">
        <div class="son">
            <label for="user_name">姓名：</label><input type="text" name="user_name" id="user_name"><br>
        </div>
        <div class="son">
            <label for="user_pwd">密码：</label><input type="password" name="user_pwd" id="user_pwd"><br>
        </div>
        <div class="son">
            <label for="user_sex">性别：</label><input type="text" name="user_sex" id="user_sex"><br>
        </div>
        <div class="son">
            <label for="user_phone">电话：</label><input type="text" name="user_phone" id="user_phone"><br>
        </div>
        <div class="son">
            <label for="user_type">类型：</label><input type="text" name="user_type" id="user_type"><br>
        </div>
        <div class="son">
            <label for="user_path">路径：</label><input type="text" name="user_path" id="user_path"><br>
        </div>
        <div class="son1">
            <input type="submit" value="提交">
        </div>

    </form>
</div>

</body>
</html>
