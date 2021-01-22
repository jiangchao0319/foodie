package com.imooc.control;

import com.imooc.pojo.Users;
import com.imooc.service.UsersService;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(value = "注册登录", tags = {"用于注册登录的相关接口"})
@RestController
public class UserController {

    @Autowired
    UsersService usersService;

    @ApiOperation(value = "根据用户id查询用户", httpMethod = "GET")
    @GetMapping("/user")
    public Users selectUserById(@RequestParam String id) {
        return usersService.selectById(id);
    }

    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @GetMapping("userNameIsExict")
    public IMOOCJSONResult selectUserIsExist(@RequestParam String userName) {
        if (StringUtils.isBlank(userName)) {
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        Boolean isExict = usersService.queryUserNameIsExist(userName);
        if (isExict) {
            return IMOOCJSONResult.errorMsg("用户已存在");
        }
        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "注册", httpMethod = "POST")
    @PostMapping("/register")
    public IMOOCJSONResult register(@RequestBody Users users) {
        String userName = users.getUsername();
        String passWord = users.getPassword();
        if(StringUtils.isBlank(userName)){
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        if(StringUtils.isBlank(passWord)){
            return IMOOCJSONResult.errorMsg("密码不能为空");
        }
        Users users1 = new Users();
        users1.setId(Sid.next());
        users1.setUsername(users.getUsername());
        try {
            users1.setPassword(MD5Utils.getMD5Str((users.getPassword())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        users1.setNickname(users.getNickname());
        users1.setRealname(users.getRealname());
        users1.setMobile(users.getMobile());
        users1.setEmail(users.getEmail());
        users.setSex(users.getSex());
        users1.setBirthday(users.getBirthday());
        users1.setCreatedata(new Date());
        users1.setUpdatedata(new Date());
        System.out.println(users1.toString());
        int result = usersService.register(users1);
        if(result == 1){
            return IMOOCJSONResult.ok(users1);
        }
        return IMOOCJSONResult.errorMsg("注册失败");
    }

}
