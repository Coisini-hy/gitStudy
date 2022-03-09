package com.neu.users.service;

import com.neu.users.dao.UsersDao;
import com.neu.users.dao.UsersDaoImply;
import com.neu.users.entity.Users;

public class UsersServiceImply implements UsersService{
    private final UsersDao usersDao = new UsersDaoImply();
    @Override
    public Users uLogin(String name, String pwd) {
        return usersDao.uLogin(name,pwd);
    }

    @Override
    public int uRegister(Users u) {
        return usersDao.uRegister(u);
    }

    @Override
    public void uModify(Users u) {
        usersDao.uModify(u);
    }

    @Override
    public Users findById(int id) {
        return usersDao.findById(id);
    }
}
