package com.imooc.serviceImpl;

import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Users;
import com.imooc.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UsersMapper usersMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insertUser(Users users) {
        usersMapper.insert(users);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delUserById(int userId) {
        usersMapper.deleteByPrimaryKey(userId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUser(Users users) {
        usersMapper.updateByPrimaryKey(users);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users getUserById(int userId) {
        return usersMapper.selectByPrimaryKey(userId);
    }
}
