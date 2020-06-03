package com.example.zero.controller;

import com.example.zero.common.SzpJsonResult;
import com.example.zero.pojo.User;
import com.example.zero.request.AddUserRequest;
import com.example.zero.request.LoginRequest;
import com.example.zero.request.SelectRequest;
import com.example.zero.request.UpdateUserRequest;
import com.example.zero.response.LoginResponse;
import com.example.zero.response.UserResponse;
import com.example.zero.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NiuLilu on 2020-05-22 13:38.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("通过id查找用户")
    @GetMapping(value = "get/user/id")
    public SzpJsonResult<User> getUserByUserId(@RequestParam(value = "userId")@ApiParam(value = "用户id")Long userId){
        return SzpJsonResult.ok(userService.getUserByUserId(userId));
    }
    @ApiOperation("用户登录")
    @PostMapping(value = "login")
    public SzpJsonResult<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginResponse login = userService.login(loginRequest);
        if (login.getToken()!=null)
        return SzpJsonResult.ok(login);
        else
            return new SzpJsonResult(401,"账号或密码错误",null);
    }
    @ApiOperation("用户注册")
    @PostMapping(value = "register")
    public SzpJsonResult<Integer> register(@RequestBody AddUserRequest addUserRequest){
        return SzpJsonResult.ok(userService.addUser(addUserRequest));
    }
    @ApiOperation("更新信息")
    @PutMapping(value = "update/user")
    public SzpJsonResult<Integer> updateUser(@RequestBody UpdateUserRequest addUserRequest){
        return SzpJsonResult.ok(userService.updateUser(addUserRequest));
    }
    @ApiOperation("关键字模糊查询")
    @DeleteMapping(value = "delete/user/{id}")
    public SzpJsonResult<Integer> deleteUser(@PathVariable(value = "id")Long id){
        return SzpJsonResult.ok(userService.deleteUserById(id));
    }
    @ApiOperation("判断用户是否存在")
    @GetMapping(value = "exist/user")
    public SzpJsonResult<Integer> exist(@RequestParam(value = "accountNumber")String accountNumber){
        return SzpJsonResult.ok(userService.exist(accountNumber));
    }
    @ApiOperation("查询全部学生")
    @PostMapping(value = "select/student")
    public SzpJsonResult<UserResponse> selectStudent(@RequestBody SelectRequest selectRequest){
        return SzpJsonResult.ok(userService.selectStudent(selectRequest));
    }
    @ApiOperation("查询全部老师")
    @PostMapping(value = "select/teacher")
    public SzpJsonResult<UserResponse> selectTeacher(@RequestBody SelectRequest selectRequest){
        return SzpJsonResult.ok(userService.selectTeacher(selectRequest));
    }
}
