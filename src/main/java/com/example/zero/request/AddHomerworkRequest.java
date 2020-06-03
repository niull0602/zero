package com.example.zero.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * Created by NiuLilu on 2020-05-22 23:24.
 */
@Data
public class AddHomerworkRequest {
    private Long userId;

    private Long classId;

    private Long courseId;


    private String homeworkFileName;

    private String homeworkUrl;
    @ApiModelProperty(value = "前端处理字段")
    private Short mark=1;

    private Long publishId;

}
