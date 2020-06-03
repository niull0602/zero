package com.example.zero.controller;

import com.example.zero.common.SzpJsonResult;
import com.example.zero.request.AddCourseShipRequest;
import com.example.zero.service.StudyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NiuLilu on 2020-05-22 23:04.
 */
@RestController
public class StudyController {
    @Autowired
    private StudyService studyService;

    @ApiOperation("学生添加课程")
    @PostMapping(value = "student/add/course")
    public SzpJsonResult<Integer> teacherAddCourse(@RequestBody AddCourseShipRequest addCourseShipRequest){
        return SzpJsonResult.ok(studyService.studentAddCourse(addCourseShipRequest));
    }

    @ApiOperation("学生删除课程")
    @DeleteMapping(value = "student/delete/course/{id}")
    public SzpJsonResult<Integer> teacherDeleteCourse(@PathVariable(value = "id")Long id){
        return SzpJsonResult.ok(studyService.studentDeleteCourse(id));
    }
}
