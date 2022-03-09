package com.neu.movies.servlet;

import com.neu.movies.entity.Movies;
import com.neu.movies.service.MoviesService;
import com.neu.movies.service.MoviesServiceImply;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateMovServlet", value = "/UpdateMovServlet")
public class UpdateMovServlet extends HttpServlet{
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
        //获取前端的参数
        PublicMethod publicMethod = new PublicMethod();
        Movies movies = publicMethod.doParam(req);
        Integer m_id = Integer.parseInt(req.getParameter("m_id"));
        movies.setM_id(m_id);
        //引入业务层代码
        MoviesService moviesService = new MoviesServiceImply();
        moviesService.update(movies);
        //跳转页面
       resp.sendRedirect("/PageMovServlet");
    }
}
