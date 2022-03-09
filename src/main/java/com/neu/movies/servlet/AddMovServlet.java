package com.neu.movies.servlet;

import com.neu.movies.entity.Movies;
import com.neu.movies.service.MoviesService;
import com.neu.movies.service.MoviesServiceImply;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddMovServlet", value = "/AddMovServlet")
public class AddMovServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        //调用业务层接口
        MoviesService moviesService = new MoviesServiceImply();
        PublicMethod publicMethod = new PublicMethod();
        int count = moviesService.addMovies(publicMethod.doParam(req));
        if (count>0) {
            resp.sendRedirect("/PageMovServlet");
        }
        else {
            resp.sendRedirect("/adm/addMovies.jsp");
        }
    }
}
