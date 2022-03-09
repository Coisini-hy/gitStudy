package com.neu.admin.service;

import com.neu.admin.entity.Admin;

public interface AdminService {
    //登录
    public Admin aLogin(String name, String pwd);
}
