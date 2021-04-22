package com.dylan.learnmybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dylan.learnmybatis.model.dto.UserDto;
import com.dylan.learnmybatis.model.entity.UserEntity;
import com.dylan.learnmybatis.model.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    List<UserVo> getUsers();

    UserVo getUserByName(String userName);

    int updateUserByUserDto(UserDto userDto);

}
