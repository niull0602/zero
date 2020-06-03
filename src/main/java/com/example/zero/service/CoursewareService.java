package com.example.zero.service;

import com.example.zero.request.SelectCoursewareRequest;
import com.example.zero.request.AddCoursewareRequest;
import com.example.zero.request.UpdateCoursewareRequest;
import com.example.zero.response.CoursewareReponseList;

/**
 * Created by NiuLilu on 2020-05-22 21:15.
 */
public interface CoursewareService {
    Integer uploadCourseware(AddCoursewareRequest addCoursewareRequest);

    Integer updateCourseware(UpdateCoursewareRequest addCoursewareRequest);

    CoursewareReponseList downloadCourseware(SelectCoursewareRequest selectCoursewareRequest);
}
