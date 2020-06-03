package com.example.zero.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-22 22:03.
 */
@Data
public class UserSelectRequest {
    private Integer pageNumber=1;

    private Integer pageSize=10;

    private Long userId;
}
