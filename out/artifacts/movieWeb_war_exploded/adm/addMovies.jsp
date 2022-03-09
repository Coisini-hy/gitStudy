<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/1/13
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加电影页面</title>
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
        width: 520px;
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
    <a href="/adm/success.jsp" id="return">返回上页</a>
</div>
<div id="content">
    <h1>添加电影界面</h1>
    <form action="${pageContext.request.contextPath}/AddMovServlet" method="post">
        <div class="son">
            <label for="m_infoLink">电影地址：</label><input type="text" name="m_infoLink" id="m_infoLink"><br>
        </div>
         <div class="son">
             <label for="m_picLink">图片地址：</label><input type="text" name="m_picLink" id="m_picLink"><br>
         </div>
        <div class="son">
            <label for="m_name">电影姓名：</label><input type="text" name="m_name" id="m_name"><br>
        </div>
        <div class="son">
            <label for="m_score">电影评分：</label><input type="text" name="m_score" id="m_score"><br>
        </div>
         <div class="son">
             <label for="m_rated">观看人数：</label><input type="text" name="m_rated" id="m_rated"><br>
         </div>
         <div class="son">
             <label for="m_instruction">电影简介：</label><input type="text" name="m_instruction" id="m_instruction"><br>
         </div>
         <div class="son">
             <label for="m_info">详细信息：</label><input type="text" name="m_info" id="m_info"><br>
        </div>
         <div class="son1">
             <input type="submit" value="添加">
        </div>
    </form>
</div>
</body>
</html>
