package com.neu.admin.servlet;

import com.neu.utils.Constant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginOutServlet", value = "/AdminLoginOutServlet")
public class AdminLoginOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object admin_session = req.getSession().getAttribute(Constant.ADMIN_SESSION);
        if (admin_session!=null) {
            req.getSession().removeAttribute(Constant.ADMIN_SESSION);
            req.getSession().removeAttribute("admin");
            req.getRequestDispatcher("/adminLogin.jsp").forward(req,resp);
        }
    }
}
