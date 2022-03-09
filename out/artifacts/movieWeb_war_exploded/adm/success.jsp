<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/1/13
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员成功登录</title>
</head>
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
    #bar a:hover{
        color: #2a96bb;
    }
    button{
        border: 0;
        margin: 0;
        padding: 0;
        width: 240px;
        height: 60px;
        font-size: 30px;
        background-color: #1ac01a;
        color: whitesmoke;
    }
    button:hover{
        background-color: #0b960b;
    }
    button a{
        text-decoration: none;
        color: whitesmoke;
    }
    #neu{
        display: flex;
        flex-direction: row;
        justify-content: space-evenly;
        margin-top: 50px;
    }
    #img{
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #img img{
        width: 800px;
        border: 0;
    }
</style>
<body>
<div id="bar">
    <p>欢迎<a href="#">${admin.admin_name}</a></p>
</div>
<div id="neu">
    <button><a href="${pageContext.request.contextPath}/AdminLoginOutServlet">退出登录</a></button>
    <button><a href="${pageContext.request.contextPath}/PageMovServlet">电影信息展示</a></button>
    <button><a href="/adm/addMovies.jsp">添加电影</a></button>
</div>
<div id="img">
    <img src="/images/word.jpg" alt="词云">
</div>
</body>
</html>
