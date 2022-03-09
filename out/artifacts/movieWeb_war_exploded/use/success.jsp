<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2022/1/13
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    function searchKey() {
        location.href = "/mov/queryKey.jsp";
    }
</script>
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
<%
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html");
    response.setCharacterEncoding("utf-8");
    // 首先判断用户是否勾选了记住账户信息,如果勾选了值默认是on,也可以通过input的value属性设置
    String[] r = request.getParameterValues("isChecked");
    if (r != null && r.length > 0) {
        // 获取输入的username和password,进行编码
        String username = URLEncoder.encode(request.getParameter("user_name"), "utf-8");
        String password = URLEncoder.encode(request.getParameter("user_pwd"), "utf-8");
        // 新建cookie对象
        Cookie usernameCookie = new Cookie("usernameCookie", username);
        Cookie passwordCookie = new Cookie("passwordCookie", password);
        // 设置cookie的有效期7天，单位为秒
        usernameCookie.setMaxAge(604800);
        passwordCookie.setMaxAge(604800);
        // 写入cookie对象
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);
    } else {
        //如果用户取消了记住账户信息，则应该对cookie里的信息进行清理
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                if (c.getName().equals("usernameCookie") || c.getName().equals("passwordCookie")) {
                    // 使cookie过期
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
        }
    }
%>
<div id="bar">
    <p>欢迎<a href="/use/userCenter.jsp">${user.user_name}</a>登录</p>
</div>
<div id="neu">
    <button><a href="${pageContext.request.contextPath}/UsersLoginOutServlet">用户退出登录</a></button>
    <button onclick="searchKey()">电影模糊搜索</button>
    <button><a href="${pageContext.request.contextPath}/PageMovServlet">电影信息展示</a></button>
</div>
<div id="img">
    <img src="/images/word.jpg" alt="词云">
</div>
</body>
</html>
