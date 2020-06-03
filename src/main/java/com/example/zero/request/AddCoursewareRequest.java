package com.example.zero.request;

import lombok.Data;


/**
 * Created by NiuLilu on 2020-05-23 0:29.
 */
@Data
public class AddCoursewareRequest {
    private Long userId;

    private Long classId;

    private Long courseId;

    private String coursewareFileName;

    /**
     * 课件资源
     */
    private String coursewareUrl;

    /**
     * 下载次数
     */
    private Integer downloadTotal=0;
}
