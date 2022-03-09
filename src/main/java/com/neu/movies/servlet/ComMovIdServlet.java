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

@WebServlet(name = "ComMovIdServlet", value = "/ComMovIdServlet")
public class ComMovIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        //获取前端参数
        Integer m_id = Integer.parseInt(req.getParameter("id"));
        //调用业务层数据
        MoviesService moviesService = new MoviesServiceImply();
        List<Comments> comList = moviesService.getIdCom(m_id);
        if (comList!=null) {
            req.setAttribute("comList",comList);
            req.setAttribute("num",comList.size());
            //resp.sendRedirect("/mov/watchPage.jsp");
            req.getRequestDispatcher("/mov/watchPage.jsp").forward(req,resp);
        }
    }
}
