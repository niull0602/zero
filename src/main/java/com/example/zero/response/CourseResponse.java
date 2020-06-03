package com.example.zero.response;

import com.example.zero.pojo.Course;
import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-22 21:03.
 */
@Data
public class CourseResponse {
    private List<Course> list;

    private Long total;

}
