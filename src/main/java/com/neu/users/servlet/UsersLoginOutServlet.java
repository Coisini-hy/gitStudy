package com.neu.users.servlet;

import com.neu.utils.Constant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UsersLoginOutServlet", value = "/UsersLoginOutServlet")
public class UsersLoginOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object user_session = req.getSession().getAttribute(Constant.USER_SESSION);
        if (user_session!=null) {
            req.getSession().removeAttribute(Constant.USER_SESSION);
            //req.getRequestDispatcher("/usersLogin.jsp").forward(req,resp);
            resp.sendRedirect("/usersLogin.jsp");
        }
    }
}
