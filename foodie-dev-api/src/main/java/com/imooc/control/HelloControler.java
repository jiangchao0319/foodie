package com.imooc.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class HelloControler {

    @GetMapping("/hello")
    public Object hello(){
        return "Hello World";
    }
}
