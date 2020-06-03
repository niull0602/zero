package com.example.zero.request;

import lombok.Data;


import java.util.Date;

/**
 * Created by NiuLilu on 2020-05-22 13:53.
 */
@Data
public class AddUserRequest {
    private String accountNumber;

    private String password;

    private String name;

    private String sex;

    private Integer age;

    /**
     * 0：学生 1：教师 2:admin
     */
    private Short mark=0;

}
