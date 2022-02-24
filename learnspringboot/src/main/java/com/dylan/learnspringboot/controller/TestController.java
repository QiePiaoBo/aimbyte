package com.dylan.learnspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2022/2/21 16:53
 */
@RestController
@RequestMapping()
public class TestController {

    @RequestMapping("hello")
    public String sayHello(){
        return "Hello, Mr.Sun.";
    }
}
