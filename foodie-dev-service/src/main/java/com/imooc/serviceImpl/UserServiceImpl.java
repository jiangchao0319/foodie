package com.imooc.serviceImpl;

import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Users;
import com.imooc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UsersMapper usersMapper;

    @Override
    public void insertUser(Users users) {

    }

    @Override
    public void delUserById(int userId) {

    }

    @Override
    public void updateUser(Users users) {

    }

    @Override
    public Users getUserById(int userId) {
        return usersMapper.selectByPrimaryKey(userId);
    }
}
