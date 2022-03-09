package com.neu.filter;

import com.neu.utils.Constant;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "UsersFilter", value = "/use/*")
public class UsersFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //判断是否存在已经固定的session的key，如果不存在重定向到错误界面
        if (req.getSession().getAttribute(Constant.USER_SESSION)==null) {
            req.getSession().removeAttribute(Constant.USER_SESSION);
            req.getSession().removeAttribute("user");
            resp.sendRedirect("/usersLogin.jsp");
        }
        chain.doFilter(request,response);
    }
}
