package com.soar.service.impl;


import com.soar.bean.Users;
import com.soar.dao.UsersDao;
import com.soar.dao.impl.UsersDaoImpl;
import com.soar.service.UsersService;

public class UsersServiceImpl implements UsersService {
    private UsersDao user = new UsersDaoImpl();

    @Override
    public Users login(String username, String password) {
        return user.login(username,password);
    }
}
