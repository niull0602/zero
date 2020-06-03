package com.example.zero.service;

import com.example.zero.request.AddCourseShipRequest;

/**
 * Created by NiuLilu on 2020-05-22 22:51.
 */
public interface TeachService {
    Integer teacherAddCourse(AddCourseShipRequest addCourseShipRequest);

    Integer teacherDeleteCourse(Long id);
}
