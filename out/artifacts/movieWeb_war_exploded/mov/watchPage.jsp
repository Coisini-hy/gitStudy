<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/1/15
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>电影详情</title>
</head>
<style>
    body {
        text-align: center;
    }

    video {
        border: 2px #3b3663 solid;
    }

    #context {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        flex-wrap: wrap;
    }

    #return {
        text-align: left;
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

    #mes {
        width: 1000px;
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        align-items: center;
        font-size: 28px;
        margin-top: 50px;
    }

    #mes p {
        margin: 0 20px 0 20px;
        padding: 0;
    }

    #mes input[type="text"] {
        width: 60%;
        height: 50px;
        border-radius: 12px;
        padding-left: 20px;
    }

    #mes input[type="submit"] {
        width: 80px;
        height: 50px;
        border: 0;
        margin: 0 20px 0 20px;
        border-radius: 12px;
        background-color: #1da1f2;
        color: white;
    }

    #des {
        width: 1000px;
        font-size: 18px;
        display: flex;
        flex-direction: row;
        justify-content: flex-start;
    }

    #des a {
        text-decoration: none;
        color: burlywood;
        display: flex;
        align-items: center;
        justify-content: center;
        margin-left: 20px;
    }

    #con {
        display: flex;
        flex-direction: column;
        justify-content: flex-start;
        align-items: flex-start;
    }

    #re {
        width: 1000px;
        height: 60px;
        font-size: 28px;
        font-weight: bold;
        display: flex;
        justify-content: flex-start;
    }

    #comment {
        margin: 10px 0 10px 80px;
        display: flex;
        flex-direction: row;
        justify-content: flex-start;
        align-items: flex-start;

    }

    #spa {
        font-size: 30px;
        width: 100px;
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 10px;
    }

    #words {
        width: 600px;
        display: flex;
        padding-left: 20px;
        flex-direction: column;
        justify-content: center;
        align-items: flex-start;
        font-size: 18px;
    }
    #wor{
        padding-bottom: 20px;
        text-align: left;
    }
    #collect{
        width: 600px;
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        font-size: 12px;
    }
    #collect a{
        text-decoration: none;
        color: black;
        font-size: 12px;
    }
</style>
<body>
<div>
    <div id="btn">
        <a href="/mov/queryKey.jsp" id="return">返回上页</a>
    </div>
    <div id="context">
        <h1>${sessionScope.m.m_name}</h1>
        <video src="/videos/v1.mp4" width="1000px" height="500px" controls="controls" poster="/images/sbpk.jpg"></video>
        <div id="des">
            <p>简介：${sessionScope.m.m_instruction}</p><a href="${m.m_infoLink}">详情</a>
        </div>
        <form action="${pageContext.request.contextPath}/ComMovServlet">
            <div id="mes">
                <p>发表评论：</p>
                <input name="m_id" type="hidden" value="${sessionScope.m.m_id}">
                <input type="text" name="comment" placeholder="发表一条友善的评论">
                <input type="submit" value="发布">
            </div>
        </form>
        <div id="con">
            <p id="re">评论(${num})：</p>
            <c:forEach items="${comList}" var="c">
                <div id="comment">
                    <span id="spa">${c.user_name}</span>
                    <div id="words">
                        <span id="wor" name="comment">${c.ur_comment}</span>
                        <div id="collect">
                            <span id="da">${c.ur_date}</span>
                            <c:set var="user" scope="session"  value="${user}"/>
                            <c:if test="${user.user_name==c.user_name}">
                                <a href="${pageContext.request.contextPath}/DeleteComServlet?p1=${c.ur_id}&p2=${m.m_id}">删除</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
