package com.neu.admin.service;

import com.neu.admin.dao.AdminDao;
import com.neu.admin.dao.AdminDaoImply;
import com.neu.admin.entity.Admin;

public class AdminServiceImply implements AdminService{
    private AdminDao adminDao = new AdminDaoImply();
    @Override
    public Admin aLogin(String name, String pwd) {
        return adminDao.aLogin(name,pwd);
    }
}
