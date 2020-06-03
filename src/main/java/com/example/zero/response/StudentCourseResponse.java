package com.example.zero.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-31 11:44.
 */
@Data
public class StudentCourseResponse {
    private Long id;
    @ApiModelProperty(value = "教师id")
    private Long userId;

    private String name;
    @ApiModelProperty(value = "班级id")
    private Long classId;

    private String courseName;

    private String bookName;
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
