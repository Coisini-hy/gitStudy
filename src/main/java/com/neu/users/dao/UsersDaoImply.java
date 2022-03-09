package com.neu.users.dao;

import com.neu.users.entity.Users;
import com.neu.utils.BaseDao;

import java.sql.SQLException;

public class UsersDaoImply extends BaseDao implements UsersDao{
    @Override
    public Users uLogin(String name, String pwd)  {
        Users users = null;
        //编写sql
        String sql = "select * from users where user_name=? and user_pwd=?";
        //执行sql
        super.query(sql, name, pwd);
        try {
            if (rs.next()) {
                users = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),
                        rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int uRegister(Users u) {
        //编写sql
        String sql = "insert into users values(0,?,?,?,?,?,?)";
        //执行sql
        return super.update(sql,u.getUser_name(),u.getUser_pwd(),u.getUser_sex(),u.getUser_phone(),
                u.getUser_type(), u.getUser_path());
    }

    @Override
    public void uModify(Users u) {
        //编写sql
        String sql = "update users set user_name=?,user_pwd=?,user_sex=?,user_phone=?," +
                "user_type=?,user_path=? where user_id=?";
        //执行sql
        super.update(sql,u.getUser_name(),u.getUser_pwd(),u.getUser_sex(),u.getUser_phone(),
                u.getUser_type(),u.getUser_path(),u.getUser_id());
    }

    @Override
    public Users findById(int id) {
        Users user = null;
        //编写sql
        String sql = "select * from users where user_id=?";
        //执行sql
        super.query(sql,id);
        try {
            if (rs.next()) {
                user = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),
                        rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
