package com.example.zero.response;

import com.example.zero.pojo.User;
import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-22 14:12.
 */
@Data
public class UserResponse {
    private List<User> list;
    private Long total;
}
