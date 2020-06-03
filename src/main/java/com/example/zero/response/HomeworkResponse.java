package com.example.zero.response;


import com.example.zero.pojo.User;
import lombok.Data;

import java.util.Date;

/**
 * Created by NiuLilu on 2020-05-22 23:31.
 */
@Data
public class HomeworkResponse {
    private Long id;

    /**
     * 上传者的id
     */

    private Long userId;

    private Long classId;

    private Long courseId;

    private String homeworkFileName;

    private String homeworkUrl;

    private String createTime;

    private Short mark;

    private String className;

    private String courseName;
    //publish
    private String homeworkName;
    //publish
    private String content;

    private User user;
}
