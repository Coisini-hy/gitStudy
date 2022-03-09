<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/1/14
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>电影查询页面</title>
</head>
<style>
    #content {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    #pic {
        padding: 10px;
        display: inline-flex;
    }

    #images{
        width: 160px;
        display: inline-block;
    }
    #context{
        padding-left: 30px;
    }
    #item {
        width: 800px;
        height: 240px;
        margin: 20px;
        padding: 10px;
        display: flex;
        flex-direction: row;
    }
    #title {
        font-size: 28px;
        font-weight: bold;
        margin: 10px 0 15px 0;
    }

    .tip {
        font-size: 16px;
        padding: 5px;
        text-align: left;
    }
    .watch{
        margin: 0;
        padding: 0;
        width: 80px;
        height: 30px;
        background-color: red;
        border: 0px;
        display: flex;
        flex-direction: column;
        flex-wrap: wrap;
        justify-content: center;
        align-content: center;
    }
    .watch:hover {
        background-color: #e04b4b;
    }
    .watch a{
        text-decoration: none;
        color: whitesmoke;
        font-size: 16px;
        font-weight: bold;

    }
    #info a{
        text-decoration: none;
        color:burlywood;
    }
    #key{
        width: 300px;
        height: 40px;
        outline-style: none;
        margin: 0 10px 0 10px;
        border: 1px black solid;
        border-radius: 8px;
        padding: 0 10px 0 10px;
    }
    #search{
        width: 80px;
        height: 40px;
        margin: 0 10px 0 10px;
        padding: 0;
        border: 0;
        color: white;
        border-radius: 8px;
        background-color: #1da1f2;
    }
    label{
        font-size: 18px;
    }
    #form{
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        align-items: center;
    }
    #num{
        font-size: 16px;
    }
    #btn{
        display: flex;
        justify-content: flex-start;
    }
    #btn a{
        text-decoration: none;
        font-size: 20px;
        padding: 20px 0 0 50px;
        color: black;
    }}
</style>
<body>
<div id="btn">
    <a href="/use/success.jsp">返回上一级</a>
</div>
<div id="content">
    <h1>电影查询页面</h1>
    <form action="${pageContext.request.contextPath}/QueryKeyServlet" method="post" id="form">
        <label for="key">请输入关键词搜索：</label><input type="text" name="key" id="key">
        <input type="submit" id="search" value="搜索">
        <c:set var="numbers"  value="${numbers}"/>
        <c:if test="${numbers > 0}">
            <p id="num">共为您搜索到<b>${numbers}</b>条信息</p>
        </c:if>
    </form>
    <c:forEach items="${moviesList}" var="m">
        <div id="item">
            <div id="pic"><img src="${m.m_picLink}" referrerpolicy="no-referrer" id="images" alt="电影海报"></div>
            <div id="context">
                <p id="title">${m.m_name}</p>
                <div id="col">
                    <span class="tip">评分：${m.m_score}</span>|<span class="tip">观看人数：${m.m_rated}</span>|<span
                        class="tip">简介：${m.m_instruction}</span>
                </div>
                <p id="info">${m.m_info}&nbsp;&nbsp;&nbsp;<a href="${m.m_infoLink}">详情</a></p>
                <div>
                    <button class="watch"><a href="${pageContext.request.contextPath}/WatchIdServlet?id=${m.m_id}">观看</a></button>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<%--<c:if test="${index>1}">--%>
<%--    <a href="${pageContext.request.contextPath}/PageMovServlet?index=1">首页</a>--%>
<%--    <a href="${pageContext.request.contextPath}/PageMovServlet?index=${index-1}">前一页</a>第${index}页--%>
<%--</c:if>--%>
<%--<c:if test="${total>index}">--%>
<%--    <a href="${pageContext.request.contextPath}/PageMovServlet?index=${index+1}">下一页</a>--%>
<%--    <a href="${pageContext.request.contextPath}/PageMovServlet?index=${total}">末页</a>共${total}页--%>
<%--</c:if>--%>
</body>
</html>
