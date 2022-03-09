package com.neu.movies.servlet;

import com.neu.movies.entity.Movies;
import com.neu.movies.service.MoviesService;
import com.neu.movies.service.MoviesServiceImply;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FindByIdServlet", value = "/FindByIdServlet")
public class FindByIdServlet extends HttpServlet {
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
        //调用业务层代码
        MoviesService moviesService = new MoviesServiceImply();
        Movies movies = moviesService.findById(id);
        if (movies!=null) {
            req.setAttribute("m",movies);
            req.getRequestDispatcher("/mov/modifyMovies.jsp").forward(req,resp);
        }
        else{
            resp.sendRedirect("/PageMovServlet");
        }
    }
}
