package com.neu.admin.dao;

import com.neu.admin.entity.Admin;

public interface AdminDao {
    //登录
    public Admin aLogin(String name, String pwd);
}
