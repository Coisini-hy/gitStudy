package com.neu.filter;

import com.neu.utils.Constant;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter" ,value = "/adm/*")
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //判断是否存在已经固定的session的key，如果不存在重定向到错误界面
        if (req.getSession().getAttribute(Constant.ADMIN_SESSION)==null) {
            req.getSession().removeAttribute(Constant.ADMIN_SESSION);
            req.getSession().removeAttribute("admin");
            resp.sendRedirect("/adminLogin.jsp");
        }
        chain.doFilter(req, resp);
    }
}
