package com.example.zero.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-22 21:08.
 */
@Data
public class SearchCourseRequest {
    private Integer pageNumber=1;
    private Integer pageSize=10;

    private String keyword;
}
