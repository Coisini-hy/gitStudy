package com.neu.users.dao;

import com.neu.users.entity.Users;

public interface UsersDao {
    //登录
    public Users uLogin(String name, String pwd);
    //注册
    public int uRegister(Users u);
    //修改信息
    public void uModify(Users u);
    //根据id寻找用户
    public Users findById(int id);
}
