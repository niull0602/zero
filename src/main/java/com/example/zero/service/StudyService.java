package com.example.zero.service;

import com.example.zero.request.AddCourseShipRequest;

/**
 * Created by NiuLilu on 2020-05-22 23:05.
 */
public interface StudyService {
    Integer studentAddCourse(AddCourseShipRequest addCourseShipRequest);

    Integer studentDeleteCourse(Long id);
}
