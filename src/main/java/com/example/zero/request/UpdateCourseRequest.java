package com.example.zero.request;

import lombok.Data;

import java.util.Date;

/**
 * Created by NiuLilu on 2020-05-22 19:30.
 */
@Data
public class UpdateCourseRequest {
    private Long id;

    private String courseName;

    private String address;

    private String courseTime;
}
