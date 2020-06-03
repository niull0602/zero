package com.example.zero.response;

import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-31 15:37.
 */
@Data
public class PublishHomeworkResponseList {
    private List<PublishHomeworkResponse> list;

    private Long total;
}
