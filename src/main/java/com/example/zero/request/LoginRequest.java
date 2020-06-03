package com.example.zero.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-22 13:42.
 */
@Data
public class LoginRequest {
    private String accountNumber;

    private String password;
}
