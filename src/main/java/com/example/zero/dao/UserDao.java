package com.example.zero.dao;

import com.example.zero.mapper.UserMapper;
import com.example.zero.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-22 13:38.
 */
@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public List<User> login(String accountNumber, String password) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("accountNumber",accountNumber)
                .andEqualTo("password",password);
        return userMapper.selectByExample(example);
    }

    public Integer insert(User user) {
        return userMapper.insert(user);
    }


    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public Integer deleteUserById(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteUserByIds(List<Long> ids) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andIn("id",ids);
        return userMapper.deleteByExample(example);
    }

    public Integer existUser(String accountNumber) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("accountNumber",accountNumber);
        return userMapper.selectByExample(example).size();
    }

    public List<User> selectStudent() {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("mark",0);
        return userMapper.selectByExample(example);
    }

    public List<User> selectTeacher() {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("mark",1);
        return userMapper.selectByExample(example);
    }

    public User selectUser(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

}
