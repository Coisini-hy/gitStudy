package com.neu.users.servlet;

import com.neu.users.entity.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PublicMethod {
    public Users doParam(HttpServletRequest req){
        //接收前端的参数
        String user_name = req.getParameter("user_name");
        String user_pwd = req.getParameter("user_pwd");
        String user_sex = req.getParameter("user_sex");
        String user_phone = req.getParameter("user_phone");
        String user_type = req.getParameter("user_type");
        String user_path = req.getParameter("user_path");
        //创建对象接收参数
        Users user = new Users();
        user.setUser_name(user_name);
        user.setUser_pwd(user_pwd);
        user.setUser_sex(user_sex);
        user.setUser_phone(user_phone);
        user.setUser_type(user_type);
        user.setUser_path(user_path);
        return user;
    }
}
