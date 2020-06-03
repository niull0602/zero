package com.example.zero.response;

import com.example.zero.pojo.Class;
import com.example.zero.pojo.User;
import lombok.Data;

/**
 * Created by lemon on 2020-02-23 22:58.
 */
@Data
public class LoginResponse {
    private User user;

    private String token;

    private Class classDesc;
}
