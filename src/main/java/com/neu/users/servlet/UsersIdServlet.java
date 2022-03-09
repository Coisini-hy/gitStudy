package com.neu.users.servlet;

import com.neu.movies.entity.Movies;
import com.neu.movies.service.MoviesService;
import com.neu.movies.service.MoviesServiceImply;
import com.neu.users.entity.Users;
import com.neu.users.service.UsersService;
import com.neu.users.service.UsersServiceImply;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UsersIdServlet", value = "/UsersIdServlet")
public class UsersIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端传递的参数Id
        String idStr = req.getParameter("id");
        int id = 0;
        if (idStr!=null&&idStr.length()>0) {
            id = Integer.parseInt(idStr);
        }
        //调用业务层方法
        UsersService usersService =new UsersServiceImply();
        Users users = usersService.findById(id);
        if (users!=null) {
            req.setAttribute("u",users);
            req.getRequestDispatcher("/use/modifyPwd.jsp").forward(req,resp);
        }
        else{
            resp.sendRedirect("/use/success.jsp");
        }
    }
}
