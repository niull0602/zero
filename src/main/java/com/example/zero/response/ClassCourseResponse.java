package com.example.zero.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-31 11:33.
 */
@Data
public class ClassCourseResponse {
    private List<StudentCourseResponse> list;
}
