package com.imooc.serviceImpl;

import com.imooc.enums.Sex;
import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Users;
import com.imooc.service.UsersService;
import com.imooc.utils.DateUtil;
import com.imooc.utils.MD5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service("UsersService")
public class UserServiceImpl implements UsersService {

    @Resource
    UsersMapper usersMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users selectById(String id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertUser(Users user) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Boolean queryUserNameIsExist(String userName) {
        Users users = usersMapper.selectUserByName(userName);
        if(users != null){
            return true;
        }
        return false;
    }

    @Override
    public Users Register(Users users) {
        String username = users.getUsername();
        try {
            String password = MD5Utils.getMD5Str(users.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String nickname = users.getNickname();
        String realname = users.getRealname();
        String mobile = users.getMobile();
        String email = users.getEmail();
//        int sex = Sex.secret.type;
        Date birthday = DateUtil.stringToDate("1992-03-19", "YYYY-MM-DD");
        Date createdata = new Date();
        Date updatedata = new Date();
        return null;
    }
}
