package com.neu.users.servlet;

import com.neu.users.service.UsersService;
import com.neu.users.service.UsersServiceImply;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UsersRegServlet", value = "/UsersRegServlet")
public class UsersRegServlet extends HttpServlet {
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
        //调用业务层接口
        UsersService usersService = new UsersServiceImply();
        PublicMethod publicMethod = new PublicMethod();
        int count = usersService.uRegister(publicMethod.doParam(req));
        //判断
        if (count>0) {
            req.getRequestDispatcher("/usersLogin.jsp").forward(req,resp);
        }
        else{
            resp.sendRedirect("/usersReg.jsp");
        }

    }
}
