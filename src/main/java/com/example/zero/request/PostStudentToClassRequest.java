package com.example.zero.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-31 14:48.
 */
@Data
public class PostStudentToClassRequest {
    private Long userId;

    private Long classId;
}
