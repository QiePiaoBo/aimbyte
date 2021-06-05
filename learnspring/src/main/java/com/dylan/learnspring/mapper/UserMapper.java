package com.dylan.learnspring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dylan.learnspring.model.dto.UserDto;
import com.dylan.learnspring.model.entity.UserEntity;
import com.dylan.learnspring.model.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    List<UserVo> getUsers();

    UserVo getUserByName(String userName);

    int updateUserByUserDto(UserDto userDto);

}
