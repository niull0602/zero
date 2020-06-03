package com.example.zero.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-23 0:42.
 */
@Data
public class UpdateCoursewareRequest {
    private Long id;

    private Long userId;

    private Long classId;

    private Long courseId;

    /**
     * 课件资源
     */
    private String coursewareUrl;

    /**
     * 下载次数
     */
    private Integer downloadTotal=0;
}
