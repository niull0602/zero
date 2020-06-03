package com.example.zero.service;

import com.example.zero.pojo.User;
import com.example.zero.request.AddUserRequest;
import com.example.zero.request.LoginRequest;
import com.example.zero.request.SelectRequest;
import com.example.zero.request.UpdateUserRequest;
import com.example.zero.response.LoginResponse;
import com.example.zero.response.UserResponse;

/**
 * Created by NiuLilu on 2020-05-22 13:40.
 */
public interface UserService {
    LoginResponse login(LoginRequest loginRequest);

    Integer addUser(AddUserRequest addUserRequest);

    Integer updateUser(UpdateUserRequest addUserRequest);

    Integer deleteUserById(Long id);

    Integer exist(String accountNumber);

    UserResponse selectStudent(SelectRequest selectRequest);

    UserResponse selectTeacher(SelectRequest selectRequest);

    User getUserByUserId(Long userId);
}
