package com.dylan.learnspring.controller;

import com.dylan.learnspring.model.dto.UserDto;
import com.dylan.learnspring.model.vo.AimRes;
import com.dylan.learnspring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dylan
 * @Date : Created in 14:04 2021/4/14
 * @Description : 数据库用户管理
 * @Function :
 */
@RestController
@RequestMapping("userTest")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping("add")
    public AimRes addUser(@RequestBody UserDto userDto){
        return AimRes.success();
    }

    @RequestMapping("delete")
    public AimRes deleteUser(@RequestBody UserDto userDto){

        return AimRes.success();
    }

    @RequestMapping("update")
    public AimRes updateUser(@RequestBody UserDto userDto){
        userDto.setUserDescription(null);
        return userService.updateUserByUserDto(userDto);
    }

    @RequestMapping("search")
    @ResponseBody
    public AimRes searchUser(){
        return userService.getUsers();
    }

    @RequestMapping("getByName")
    public AimRes searchUserByName(String userName){
        return userService.getUserByName(userName);
    }

    public String getString(){
        return "asd";
    }

}
