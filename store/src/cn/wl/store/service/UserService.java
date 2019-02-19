package cn.wl.store.service;

import cn.wl.store.domain.User;

import java.sql.SQLException;

public interface UserService {
    void userRegist(User user) throws SQLException;

    User userActive(String code)throws SQLException;

    void updateUser(User user)throws SQLException;
}
