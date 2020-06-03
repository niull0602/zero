package com.example.zero.controller;

import com.example.zero.common.SzpJsonResult;
import com.example.zero.request.*;
import com.example.zero.response.ClassCourseResponse;
import com.example.zero.response.CourseResponse;
import com.example.zero.response.TeacherClassCourseResponseList;
import com.example.zero.service.CourseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NiuLilu on 2020-05-22 16:14.
 */
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @ApiOperation("添加课程")
    @PostMapping(value = "add/course")
    public SzpJsonResult<Integer> addCourse(@RequestBody AddCourseRequest addCourseRequest) throws Exception {
        return SzpJsonResult.ok(courseService.addCourse(addCourseRequest));
    }

    @ApiOperation("通过id删除课程")
    @DeleteMapping(value = "delete/course/{id}")
    public SzpJsonResult<Integer> deleteCourseById(@PathVariable(value = "id")Long id){
        return SzpJsonResult.ok(courseService.deleteCourseById(id));
    }

    @ApiOperation("更新课程信息")
    @PutMapping(value = "update/course")
    public SzpJsonResult<Integer> updateCourseById(@RequestBody UpdateCourseRequest updateCourseRequest) throws Exception {
        return SzpJsonResult.ok(courseService.updateteCourseById(updateCourseRequest));
    }

    @ApiOperation("查看所有课程")
    @PostMapping(value = "select/all/course")
    public SzpJsonResult<CourseResponse> selectAllCourse(@RequestBody SelectRequest selectRequest){
        return SzpJsonResult.ok(courseService.selectAllCourse(selectRequest));
    }

    @ApiOperation("关键字模糊查询课程")
    @PostMapping(value = "find/course/keyword")
    public SzpJsonResult<CourseResponse> findCourseByKeyword(@RequestBody SearchCourseRequest selectRequest){
        return SzpJsonResult.ok(courseService.findCourseByKeyword(selectRequest));
    }

    @ApiOperation("学生查看所有课程")
    @PostMapping(value = "select/student/course")
    public SzpJsonResult<ClassCourseResponse> selectStudentCourse(@RequestBody StudentSelectCourseRequest selectRequest){
        return SzpJsonResult.ok(courseService.selectStudentCourse(selectRequest));
    }

    @ApiOperation("老师查看所有课程")
    @PostMapping(value = "select/teacher/course")
    public SzpJsonResult<TeacherClassCourseResponseList> selectTeacherCourse(@RequestBody TeacherSelectRequest selectRequest){
        return SzpJsonResult.ok(courseService.selectTeacherCourse(selectRequest));
    }
}
