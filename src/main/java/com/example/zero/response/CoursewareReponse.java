package com.example.zero.response;

import com.example.zero.pojo.User;
import lombok.Data;

import java.util.Date;

/**
 * Created by NiuLilu on 2020-05-23 0:47.
 */
@Data
public class CoursewareReponse {
    private Long id;

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
    private Integer downloadTotal;

    private Date createTime;

    private User user;
}
