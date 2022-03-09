package com.neu.movies.servlet;

import com.neu.movies.service.MoviesService;
import com.neu.movies.service.MoviesServiceImply;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteComServlet", value = "/DeleteComServlet")
public class DeleteComServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端传递的参数Id
        String idStr1 = req.getParameter("p1");
        String idStr2 = req.getParameter("p2");
        int id1 = 0,id2 =0;
        if (idStr1!=null&&idStr1.length()>0) {
            id1= Integer.parseInt(idStr1);
        }
        if (idStr2!=null&&idStr2.length()>0) {
            id2= Integer.parseInt(idStr2);
        }
        //引入业务层代码
        MoviesService moviesService = new MoviesServiceImply();
        moviesService.deleteCom(id1);
        req.getRequestDispatcher("/ComMovIdServlet?id="+id2+"").forward(req,resp);
    }
}
