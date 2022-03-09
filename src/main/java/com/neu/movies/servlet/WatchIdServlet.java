package com.neu.movies.servlet;

import com.neu.movies.entity.Comments;
import com.neu.movies.entity.Movies;
import com.neu.movies.service.MoviesService;
import com.neu.movies.service.MoviesServiceImply;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "WatchIdServlet", value = "/WatchIdServlet")
public class WatchIdServlet extends HttpServlet {
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
        List<Comments> comList = moviesService.getIdCom(id);
        if (movies!=null) {
            HttpSession session = req.getSession();
            session.setAttribute("m",movies);
            req.setAttribute("comList",comList);
            req.setAttribute("num",comList.size());
            req.getRequestDispatcher("/mov/watchPage.jsp").forward(req,resp);
        }
    }
}
