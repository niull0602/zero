package com.example.zero.mapper;

import com.example.zero.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends CommonMapper<User> {
    User selectUserByUserId(@Param(value = "userId") Long userId);
}