package com.example.zero.response;

import lombok.Data;



/**
 * Created by NiuLilu on 2020-05-31 15:37.
 */
@Data
public class PublishHomeworkResponse {
    private Long id;

    /**
     * 教师id
     */
    private Long userId;

    private String teacherName;

    private Long classId;

    private String homeworkName;

    private String teacherFileName;

    private String teacherFileUrl;

    private String content;

    private String createTime;

}
