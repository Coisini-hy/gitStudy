package com.neu.movies.servlet;

import com.neu.movies.entity.Movies;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PublicMethod {
    public Movies doParam(HttpServletRequest req){
        //获取前端的参数
        String m_infoLink = req.getParameter("m_infoLink");
        String m_picLink = req.getParameter("m_picLink");
        String m_name = req.getParameter("m_name");
        Double m_score = Double.parseDouble(req.getParameter("m_score"));
        Integer m_rated = Integer.parseInt(req.getParameter("m_rated"));
        String m_instruction = req.getParameter("m_instruction");
        String m_info = req.getParameter("m_info");
        //创建对象接收
        Movies movies = new Movies();
        movies.setM_infoLink(m_infoLink);
        movies.setM_picLink(m_picLink);
        movies.setM_name(m_name);
        movies.setM_score(m_score);
        movies.setM_rated(m_rated);
        movies.setM_instruction(m_instruction);
        movies.setM_info(m_info);
        return movies;
    }
}
