package com.neu.admin.dao;

import com.neu.admin.entity.Admin;
import com.neu.utils.BaseDao;

import java.sql.SQLException;

public class AdminDaoImply extends BaseDao implements AdminDao{
    @Override
    public Admin aLogin(String name, String pwd) {
        Admin admin  = null;
        //编写sql
        String sql = "select * from admin where admin_name=? and admin_pwd=?";
        //执行sql
        super.query(sql,name,pwd);
        try {
            if (rs.next()) {
                admin = new Admin(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
