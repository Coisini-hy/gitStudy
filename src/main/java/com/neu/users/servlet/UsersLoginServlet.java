package com.neu.users.servlet;

import com.neu.users.entity.Users;
import com.neu.users.service.UsersService;
import com.neu.users.service.UsersServiceImply;
import com.neu.utils.Constant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UsersLoginServlet", value = "/UsersLoginServlet")
public class UsersLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端参数
        String user_name = req.getParameter("user_name");
        String user_pwd = req.getParameter("user_pwd");
        //执行业务层代码
        UsersService usersService = new UsersServiceImply();
        Users users = usersService.uLogin(user_name, user_pwd);
        if (users != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", users);
            session.setAttribute(Constant.USER_SESSION, session.getId());
            req.getRequestDispatcher("/use/success.jsp").forward(req,resp);
        }
        else{
            resp.sendRedirect("/usersLogin.jsp");
        }
    }
}
