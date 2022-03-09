package com.neu.movies.servlet;

import com.neu.movies.entity.Movies;
import com.neu.movies.service.MoviesService;
import com.neu.movies.service.MoviesServiceImply;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PageMovServlet", value = "/PageMovServlet")
public class PageMovServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //引入业务层方法
        MoviesService moviesService = new MoviesServiceImply();
        //初始化
        int index = 1;
        //接收前端用户传递的参数Index
        String indexStr = req.getParameter("index");
        //对indexStr进行非空判断
        if (indexStr!=null&&indexStr.length()>0) {
            index = Integer.parseInt(indexStr);
        }
        //设置每一页显示的数据条数
        int size = 5;
        List<Movies> moviesList = moviesService.pageList(index, size);
        //查询全部记录条数
        int count = moviesService.count();
        //通过三元表达式来转换出页数
        int total = count%size==0?count/size:count/size+1;
        //将数据向前端传递
        HttpSession session = req.getSession();
        session.setAttribute("moviesList",moviesList);
        session.setAttribute("index",index);
        session.setAttribute("total",total);
        //转发
        req.getRequestDispatcher("/mov/showMovies.jsp").forward(req,resp);
    }
}
