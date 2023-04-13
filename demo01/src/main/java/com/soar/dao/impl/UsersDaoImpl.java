package com.soar.dao.impl;


import com.soar.bean.Users;
import com.soar.dao.DBUtils;
import com.soar.dao.UsersDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl extends DBUtils implements UsersDao {

    @Override
    public Users login(String username, String password) {
        String sql = "select * from users where loginname=? and password=?";
        List list = new ArrayList();
        list.add(username);
        list.add(password);
        resultSet = query(sql, list);
        if (resultSet == null){
            return null;
        }
        Users users = null;
        try {
            while (resultSet.next()){
                users = new Users();
                users.setLoginName(username);
                users.setRealName(resultSet.getString("realname"));
                users.setUserId(resultSet.getInt("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return users;
    }
}
