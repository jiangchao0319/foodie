package com.imooc.service;

import com.imooc.pojo.Users;

public interface UserService {
    void insertUser(Users users);

    void delUserById(int userId);

    void updateUser(Users users);

    Users getUserById(int userId);
}
