package com.neu.movies.servlet;

import com.neu.movies.entity.Comments;
import com.neu.movies.entity.Movies;
import com.neu.movies.service.MoviesService;
import com.neu.movies.service.MoviesServiceImply;
import com.neu.users.entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ComMovServlet", value = "/ComMovServlet")
public class ComMovServlet extends HttpServlet {
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
        HttpSession session = req.getSession();
        Users users = (Users) session.getAttribute("user");
        Integer user_id = users.getUser_id();
        String user_name = users.getUser_name();
        Integer m_id = Integer.parseInt(req.getParameter("m_id"));
        String comment = req.getParameter("comment");
        //创建对象接收
        Comments comments = new Comments();
        comments.setUser_id(user_id);
        comments.setUser_name(user_name);
        comments.setM_id(m_id);
        comments.setUr_comment(comment);
        //调用业务层
        MoviesService moviesService = new MoviesServiceImply();
        Movies movies = moviesService.findById(m_id);
        int count = moviesService.insertCom(comments);
        if (count>0) {
            req.setAttribute("m",movies);
            req.getRequestDispatcher("/ComMovIdServlet?id="+m_id+"").forward(req,resp);
        }else{
            System.out.println("插入失败");
        }
    }
}
