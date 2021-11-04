package com.dylan.learnspring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dylan.learnspring.model.dto.UserDto;
import com.dylan.learnspring.model.entity.UserEntity;
import com.dylan.learnspring.model.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
@CacheConfig(cacheManager = "myCacheManager", cacheNames = {"users"})
public interface UserMapper extends BaseMapper<UserEntity> {

    @Cacheable(keyGenerator = "myKeyGenerator")
    List<UserVo> getUsers();

    @Cacheable(keyGenerator = "myKeyGenerator")
    UserVo getUserByName(String userName);

    int updateUserByUserDto(UserDto userDto);

}
