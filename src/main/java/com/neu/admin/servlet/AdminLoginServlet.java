package com.neu.admin.servlet;

import com.neu.admin.entity.Admin;
import com.neu.admin.service.AdminService;
import com.neu.admin.service.AdminServiceImply;
import com.neu.utils.Constant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        //获取前端参数
        String admin_name = req.getParameter("admin_name");
        String admin_pwd = req.getParameter("admin_pwd");
        //调用业务层方法
        AdminService adminService = new AdminServiceImply();
        Admin admin = adminService.aLogin(admin_name,admin_pwd);
        //判断
        if (admin != null) {
            HttpSession session = req.getSession();
            session.setAttribute("admin", admin);
            session.setAttribute(Constant.ADMIN_SESSION, session.getId());
            req.getRequestDispatcher("/adm/success.jsp").forward(req,resp);
        }
        else{
            resp.sendRedirect("/adminLogin.jsp");
    }
}
}
