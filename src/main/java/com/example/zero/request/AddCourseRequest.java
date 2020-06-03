package com.example.zero.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * Created by NiuLilu on 2020-05-22 16:16.
 */
@Data
public class AddCourseRequest {
    @ApiModelProperty(value = "教师id")
    private Long userId;
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
