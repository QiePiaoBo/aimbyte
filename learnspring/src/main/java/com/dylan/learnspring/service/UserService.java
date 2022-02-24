package com.dylan.learnspring.service;

import com.dylan.learnspring.mapper.UserMapper;
import com.dylan.learnspring.model.dto.UserDto;
import com.dylan.learnspring.model.vo.AimRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Dylan
 * @Date : Created in 14:04 2021/4/14
 * @Description :
 * @Function :
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    UserMapper userMapper;

    public AimRes getUsers(){
        return new AimRes("0000", "Ok", userMapper.getUsers());
    }

    public AimRes getUserByName(String userName){
        return new AimRes("0000", "Ok", userMapper.getUserByName(userName));
    }

    public AimRes updateUserByUserDto(UserDto userDto){
        return new AimRes("0000", "Ok", userMapper.updateUserByUserDto(userDto));
    }
}
