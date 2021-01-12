package com.imooc.control;

import com.imooc.pojo.Users;
import com.imooc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public Object getUser(int userId) {
        Users users = userService.getUserById(userId);
        if(users != null){
            return users;
        }
        return "查询为空";
    }

    @PostMapping("/insertUser")
    public void insertUser(){
        Users users = new Users();
        users.setName("jc");
        users.setAge(18);
        users.setUserid(3);
        userService.insertUser(users);
    }

    @PostMapping("/deleteUser")
    public void deleteUser(int userid){
        userService.delUserById(userid);
    }

    @PostMapping("/updateUser")
    public void updateUser(){
        Users users = new Users();
        users.setName("TomNew");
        users.setAge(18);
        users.setUserid(2);
        userService.updateUser(users);
    }
}
