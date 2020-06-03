package com.example.zero.request;


import lombok.Data;


/**
 * Created by NiuLilu on 2020-05-31 15:28.
 */
@Data
public class AddPublishHomeworkRequest {
    private Long userId;

    private Long classId;

    private String teacherFileName;

    private String teacherFileUrl;

    private String homeworkName;

    private String content;

}
