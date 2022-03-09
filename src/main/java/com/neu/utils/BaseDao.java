package com.neu.utils;

import java.sql.*;

public class BaseDao {
    //1、初始化基本参数
    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    static {
        //2.  静态代码块，在类加载的时候执行
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    //3、开启数据库连接方法封装
    protected void open() {
        try {
            //3、1 将参数传递，从而正式开启数据库连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/movie?useUnicode=true&characterEncoding=utf-8",
                    "root", "0728");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //4、更新数据库的公共操作
    public int update(String sql, Object... params) {
        int count = 0;
        try {
            open();
            //4.1  预编译SQL
            ps = conn.prepareStatement(sql);
            //4.2 遍历结果集
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            //2.5 真正执行SQL
            count = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return count;
    }

    //5、查询数据库的公共操作
    public ResultSet query(String sql, Object... params) {

        try {
            open();
            //5.1  预编译SQL
            ps = conn.prepareStatement(sql);
            //5.2 遍历结果集
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            // 执行SQL
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    // 6 释放资源
    public void close() {
        if (rs != null)
            try {
                rs.close();
                rs=null;//方便GC回收
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (ps != null)
            try {
                ps.close();
                ps = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (conn != null)
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
