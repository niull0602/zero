package com.example.zero.response;

import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-23 0:47.
 */
@Data
public class CoursewareReponseList {
    private List<CoursewareReponse> list;
    private Long total;
}
