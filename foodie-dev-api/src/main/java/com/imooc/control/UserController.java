package com.imooc.control;

import com.imooc.pojo.Users;
import com.imooc.service.UsersService;
import com.imooc.utils.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UsersService usersService;

    @GetMapping("/user")
    public Users selectUserById(String id){
        return usersService.selectById(id);
    }

    @GetMapping("userNameIsExict")
    public IMOOCJSONResult selectUserIsExist(String userName){
        if(StringUtils.isBlank(userName)){
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        Boolean isExict = usersService.queryUserNameIsExist(userName);
        if(isExict){
            return IMOOCJSONResult.errorMsg("用户已存在");
        }
        return IMOOCJSONResult.ok();
    }

}
