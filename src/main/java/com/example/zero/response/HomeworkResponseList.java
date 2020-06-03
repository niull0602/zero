package com.example.zero.response;

import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-22 23:35.
 */
@Data
public class HomeworkResponseList {
    private List<HomeworkResponse> list;
    private Long total;
}
