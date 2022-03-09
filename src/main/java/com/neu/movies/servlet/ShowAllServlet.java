package com.neu.movies.servlet;

import com.neu.movies.entity.Movies;
import com.neu.movies.service.MoviesService;
import com.neu.movies.service.MoviesServiceImply;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAllServlet", value = "/ShowAllServlet")
public class ShowAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用业务层接口
        MoviesService moviesService = new MoviesServiceImply();
        //查询电影信息
        List<Movies> moviesList = moviesService.showAll();
        //向前端发送数据
        req.setAttribute("moviesList",moviesList);
        //跳转页面
        req.getRequestDispatcher("/mov/showMovies.jsp").forward(req,resp);
    }
}
