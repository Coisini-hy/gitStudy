package com.neu.users.servlet;

import com.neu.users.entity.Users;
import com.neu.users.service.UsersService;
import com.neu.users.service.UsersServiceImply;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ModifyPwdServlet", value = "/ModifyPwdServlet")
public class ModifyPwdServlet extends HttpServlet {
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
        PublicMethod publicMethod = new PublicMethod();
        Integer u_id = Integer.parseInt(req.getParameter("user_id"));
        Users user  = publicMethod.doParam(req);
        user.setUser_id(u_id);
        //引入业务层代码
        UsersService usersService = new UsersServiceImply();
        usersService.uModify(user);
        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        resp.sendRedirect("/use/userCenter.jsp");
    }
}
