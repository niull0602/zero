package com.example.zero.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-22 23:29.
 */
@Data
public class DownloadHomeworkRequest {
    private Long classId;

    private Long courseId;

    private Integer pageNumber=1;

    private Integer pageSize=10;
}
