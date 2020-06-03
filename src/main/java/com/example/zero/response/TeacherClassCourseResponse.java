package com.example.zero.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-31 19:51.
 */
@Data
public class TeacherClassCourseResponse {
    private Long id;
    @ApiModelProperty(value = "教师id")
    private Long userId;
    @ApiModelProperty(value = "班级id")
    private Long classId;

    private String className;

    private String courseName;
    @ApiModelProperty(value = "课程的详情")
    private String courseDesc;

    private Integer startWeek;

    private Integer endWeek;

    /**
     *  哪一节
     */
    @ApiModelProperty(value = "哪一节")
    private Integer section;

    private String address;

    /**
     * 星期几
     */
    @ApiModelProperty(value = "星期几")
    private Short weekday;
    @ApiModelProperty(value = "带的东西")
    private String tool;
}
