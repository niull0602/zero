package com.example.zero.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-23 1:20.
 */
@Data
public class SelectUserHomeworkRequest {
    private Integer pageNumber=1;
    private Integer pageSize=10;
    private Long userId;
}
