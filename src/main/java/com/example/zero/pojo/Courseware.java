package com.example.zero.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "t_courseware")
public class Courseware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "class_id")
    private Long classId;

    @Column(name = "courseware_file_name")
    private String coursewareFileName;

    /**
     * 课件资源
     */
    @Column(name = "courseware_url")
    private String coursewareUrl;

    /**
     * 下载次数
     */
    @Column(name = "download_total")
    private Integer downloadTotal;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}