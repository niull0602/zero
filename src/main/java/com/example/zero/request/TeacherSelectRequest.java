package com.example.zero.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-31 19:36.
 */
@Data
public class TeacherSelectRequest {
    private Long userId;

    private Integer currentWeek=1;
}
