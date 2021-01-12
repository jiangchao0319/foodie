package com.imooc.control;

import com.imooc.pojo.Users;
import com.imooc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public Object getUser(int userId) {
//        return userService.getUserById(userId);
        Users users = userService.getUserById(userId);
        if(users != null){
            return users;
        }
        return "查询为空";
    }
}
