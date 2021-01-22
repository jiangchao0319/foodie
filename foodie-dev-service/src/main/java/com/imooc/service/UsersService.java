package com.imooc.service;

import com.imooc.pojo.Users;


public interface UsersService {
    Users selectById(String id);

    void insertUser(Users user);

    void deleteById(String id);

    /*
    * 判断用户名是否存在
    * */
    Boolean queryUserNameIsExist(String userName);

    /*
    * 注册
    * */
    int register(Users users);
}
