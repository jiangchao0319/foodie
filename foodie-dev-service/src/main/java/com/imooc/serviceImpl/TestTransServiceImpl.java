package com.imooc.serviceImpl;

import com.imooc.service.TestTransService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("TestTransService")
public class TestTransServiceImpl implements TestTransService {
    @Resource
    UserServiceImpl userService;

    @Override
    public void testPropagationTrans() {
        userService.saveParent();
        userService.saveChild();
    }
}
