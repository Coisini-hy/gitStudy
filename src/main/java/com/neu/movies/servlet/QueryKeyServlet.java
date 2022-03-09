package com.neu.movies.servlet;

import com.neu.movies.entity.Movies;
import com.neu.movies.service.MoviesService;
import com.neu.movies.service.MoviesServiceImply;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryKeyServlet", value = "/QueryKeyServlet")
public class QueryKeyServlet extends HttpServlet {
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
        //获取前端参数
        String key = req.getParameter("key");
        //调用业务层代码
        MoviesService moviesService = new MoviesServiceImply();
        List<Movies> moviesList = moviesService.selectKey(key);
        //向前端传递参数
        req.setAttribute("moviesList",moviesList);
        req.setAttribute("numbers",moviesList.size());
        req.getRequestDispatcher("/mov/queryKey.jsp").forward(req,resp);
    }
}
