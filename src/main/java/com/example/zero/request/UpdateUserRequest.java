package com.example.zero.request;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by NiuLilu on 2020-05-22 13:59.
 */
@Data
public class UpdateUserRequest {
    private Long id;

    private String accountNumber;

    private String password;

    private String name;

    private String sex;

    private Integer age;

    /**
     * 0：学生 1：教师
     */
    private Short mark;

}
