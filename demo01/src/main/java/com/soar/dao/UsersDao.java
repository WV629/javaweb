package com.soar.dao;

import com.soar.bean.Users;

public interface UsersDao {
    public Users login(String username,String password);
}
