package com.example.zero.service.impl;

import com.example.zero.dao.ClassDao;
import com.example.zero.dao.StudentClassDao;
import com.example.zero.dao.UserDao;
import com.example.zero.pojo.Class;
import com.example.zero.pojo.StudentClass;
import com.example.zero.pojo.User;
import com.example.zero.request.AddUserRequest;
import com.example.zero.request.LoginRequest;
import com.example.zero.request.SelectRequest;
import com.example.zero.request.UpdateUserRequest;
import com.example.zero.response.LoginResponse;
import com.example.zero.response.UserResponse;
import com.example.zero.service.UserService;
import com.example.zero.utils.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by NiuLilu on 2020-05-22 13:40.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private StudentClassDao studentClassDao;
    @Autowired
    private ClassDao classDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        List<User> list = userDao.login(loginRequest.getAccountNumber(), loginRequest.getPassword());
        LoginResponse loginResponse = new LoginResponse();
        if (!CollectionUtils.isEmpty(list)){
            User user = list.get(0);
            loginResponse.setUser(user);
            String uuid= UUID.randomUUID().toString();
            String token=uuid+","+user.getId()+","+user.getName()+","+user.getAccountNumber();
            log.info("该用户-{},token-{}",user.toString(),token);
            //将token留在redis中
            stringRedisTemplate.opsForValue().set(token, JsonUtils.objectToJson(user));
            stringRedisTemplate.expire(token,10, TimeUnit.DAYS);
            loginResponse.setToken(token);
            StudentClass studentClass = studentClassDao.getStudentClass(user.getId());
            if (studentClass!=null) {
                Class classDesc = classDao.getClassDesc(studentClass.getClassId());
                if (classDesc != null) {
                    loginResponse.setClassDesc(classDesc);
                }
            }
        }
        return loginResponse;
    }

    @Override
    public Integer addUser(AddUserRequest addUserRequest) {
        User user = new User();
        BeanUtils.copyProperties(addUserRequest,user);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return userDao.insert(user);
    }

    @Override
    public Integer updateUser(UpdateUserRequest addUserRequest) {
        User user = new User();
        BeanUtils.copyProperties(addUserRequest,user);
        user.setUpdateTime(new Date());
        return userDao.updateUser(user);
    }

    @Override
    public Integer deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public Integer exist(String accountNumber) {
        return userDao.existUser(accountNumber);
    }

    @Override
    public UserResponse selectStudent(SelectRequest selectRequest) {
        PageHelper.startPage(selectRequest.getPageNumber(),selectRequest.getPageSize());
        List<User> userList = userDao.selectStudent();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        UserResponse userResponse = new UserResponse();
        userResponse.setList(pageInfo.getList());
        userResponse.setTotal(pageInfo.getTotal());
        return userResponse;
    }

    @Override
    public UserResponse selectTeacher(SelectRequest selectRequest) {
        PageHelper.startPage(selectRequest.getPageNumber(),selectRequest.getPageSize());
        List<User> userList = userDao.selectTeacher();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        UserResponse userResponse = new UserResponse();
        userResponse.setList(pageInfo.getList());
        userResponse.setTotal(pageInfo.getTotal());
        return userResponse;
    }

    @Override
    public User getUserByUserId(Long userId) {
        return userDao.selectUser(userId);
    }
}
