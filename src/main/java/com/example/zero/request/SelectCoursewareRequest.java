package com.example.zero.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-23 0:50.
 */
@Data
public class SelectCoursewareRequest {
    private Integer pageNumber=1;

    private Integer pageSize=10;

    private Long courseId;
}
