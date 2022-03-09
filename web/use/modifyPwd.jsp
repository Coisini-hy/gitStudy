<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/1/14
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息页面</title>
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
        width: 470px;
        height: 50px;
        border: 0;
        border-radius: 12px;
        font-size: 20px;
        background-color: red;
        color: whitesmoke;
    }
</style>
<body>
<div id="content">
    <h1>修改个人信息界面</h1>
    <form action="${pageContext.request.contextPath}/ModifyPwdServlet" method="post">
        <input type="hidden" value="${u.user_id}" name="user_id">
        <div class="son">
            <label for="user_name">姓名：</label><input type="text" value="${u.user_name}" name="user_name" id="user_name"><br>
        </div>
        <div class="son">
            <label for="user_pwd">密码：</label><input type="password" value="${u.user_pwd}" name="user_pwd" id="user_pwd"><br>
        </div>
        <div class="son">
            <label for="user_sex">性别：</label><input type="text" value="${u.user_sex}" name="user_sex" id="user_sex"><br>
        </div>
        <div class="son">
            <label for="user_phone">电话：</label><input type="text" value="${u.user_phone}" name="user_phone" id="user_phone"><br>
        </div>
        <div class="son">
            <label for="user_type">类型：</label><input type="text" value="${u.user_type}" name="user_type" id="user_type"><br>
        </div>
        <div class="son">
            <label for="user_path">路径：</label><input type="text" value="${u.user_path}" name="user_path" id="user_path"><br>
        </div>
        <div class="son1">
            <input type="submit" value="提交修改">
        </div>
    </form>
</div>
</body>
</html>
