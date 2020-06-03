package com.example.zero.service;

import com.example.zero.request.*;
import com.example.zero.response.ClassCourseResponse;
import com.example.zero.response.CourseResponse;
import com.example.zero.response.TeacherClassCourseResponseList;

/**
 * Created by NiuLilu on 2020-05-22 16:12.
 */
public interface CourseService {
    Integer addCourse(AddCourseRequest addCourseRequest) throws Exception;

    Integer deleteCourseById(Long id);

    Integer updateteCourseById(UpdateCourseRequest updateCourseRequest) throws Exception;

    CourseResponse selectAllCourse(SelectRequest selectRequest);

    CourseResponse findCourseByKeyword(SearchCourseRequest selectRequest);

    ClassCourseResponse selectStudentCourse(StudentSelectCourseRequest selectRequest);

    TeacherClassCourseResponseList selectTeacherCourse(TeacherSelectRequest selectRequest);

}
