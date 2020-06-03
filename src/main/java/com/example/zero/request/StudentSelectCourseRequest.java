package com.example.zero.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-31 11:16.
 */
@Data
public class StudentSelectCourseRequest {
  //  private Long userId;

    private Long classId;

    private Integer currentWeek=1;

   // private Integer pageNumber=1;

   // private Integer pageSize=10;
}
