<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/1/13
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>电影展示页面</title>
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
    }

    .tip {
        font-size: 16px;
        padding: 5px;
        text-align: left;
    }

    #context {
        display: flex;
        flex-direction: column;
        align-content: flex-start;
        padding: 0 20px 0 50px;
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
    }
    .watch{
        margin: 0 10px 0 10px;
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
    .watch a{
        text-decoration: none;
        color: whitesmoke;
        font-size: 16px;
        font-weight: bold;
    }
    #button{
        display: flex;
        flex-direction: row;
        justify-content: flex-start;
    }
    #info a{
        text-decoration: none;
        color:burlywood;
        margin-left: 10px;
    }
    #neu{
        width: 800px;
        display: flex;
        flex-direction: row;
        justify-content: flex-end;
        align-items: center;
        font-size: 16px;
    }
    #neu a{
        text-decoration: none;
        width: 60px;
        height: 28px;
        margin: 10px;
        background-color: #777777;
        color: whitesmoke;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .watch{
        margin: 0 10px 0 10px;
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
</style>
<body>
<c:set var="admin" scope="session"  value="${admin}"/>
<c:if test="${admin!=null}">
    <div id="btn">
        <a href="/adm/success.jsp">返回上一级</a>
    </div>
</c:if>
<c:if test="${admin==null}">
    <div id="btn">
        <a href="/use/success.jsp">返回上一级</a>
    </div>
</c:if>
<div id="content">
    <h1>电影展示页面</h1>
    <c:forEach items="${moviesList}" var="m">
        <div id="item">
            <div id="pic"><img src="${m.m_picLink}" referrerpolicy="no-referrer" id="images" alt="电影海报"></div>
            <div id="context">
                <p id="title">${m.m_name}</p>
                <div id="col">
                    <span class="tip">评分：${m.m_score}</span>|<span class="tip">观看人数：${m.m_rated}</span>|<span
                        class="tip">简介：${m.m_instruction}</span>
                </div>
                <p id="info">${m.m_info}<a href="${m.m_infoLink}">详情</a></p>
                <c:set var="admin" scope="session"  value="${admin}"/>
                <c:if test="${admin!=null}">
                    <div id="button">
                        <button class="watch"><a href="${pageContext.request.contextPath}/DeleteMovServlet?id=${m.m_id}">删除</a></button>
                        <button class="watch"><a href="${pageContext.request.contextPath}/FindByIdServlet?id=${m.m_id}">更新</a></button>
                    </div>
                </c:if>
                <c:if test="${admin==null}">
                    <div>
                        <button class="watch"><a href="${pageContext.request.contextPath}/WatchIdServlet?id=${m.m_id}">观看</a></button>
                    </div>
                </c:if>
            </div>
        </div>
    </c:forEach>
    <div id="neu">
        <c:if test="${index>1}">
            <a href="${pageContext.request.contextPath}/PageMovServlet?index=1">首页</a>
            <a href="${pageContext.request.contextPath}/PageMovServlet?index=${index-1}">前一页</a>第${index}页
        </c:if>
        <c:if test="${total>index}">
            <a href="${pageContext.request.contextPath}/PageMovServlet?index=${index+1}">下一页</a>
            <a href="${pageContext.request.contextPath}/PageMovServlet?index=${total}">末页</a>共${total}页
        </c:if>
    </div>
</div>

</body>
</html>