package com.dylan.learnspring.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dylan.learnspring.mapper.UserMapper;
import com.dylan.learnspring.model.dto.UserDto;
import com.dylan.learnspring.model.vo.AimRes;
import com.dylan.learnspring.model.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dylan
 * @Date : Created in 14:04 2021/4/14
 * @Description :
 * @Function :
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserMapper userMapper;

    public AimRes getUsers(){
        QueryWrapper<UserVo> queryWrapper = new QueryWrapper<>();

        List<UserVo> users = userMapper.getUsers();
        return new AimRes("0000", "Ok", users);
    }

    public AimRes getUserByName(String userName){
        return new AimRes("0000", "Ok", userMapper.getUserByName(userName));
    }

    public AimRes updateUserByUserDto(UserDto userDto){

        return new AimRes("0000", "Ok", userMapper.updateUserByUserDto(userDto));
    }
}
