package com.example.zero.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-22 22:54.
 */
@Data
public class AddCourseShipRequest {
    private Long userId;

    private Long courseId;
}
