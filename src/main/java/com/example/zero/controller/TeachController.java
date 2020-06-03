package com.example.zero.controller;

import com.example.zero.common.SzpJsonResult;
import com.example.zero.request.AddCourseShipRequest;
import com.example.zero.service.TeachService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NiuLilu on 2020-05-22 22:18.
 */
@RestController
public class TeachController {
    @Autowired
    private TeachService teachService;
    @ApiOperation("教师添加课程")
    @PostMapping(value = "teacher/add/course")
    public SzpJsonResult<Integer> teacherAddCourse(@RequestBody AddCourseShipRequest addCourseShipRequest){
        return SzpJsonResult.ok(teachService.teacherAddCourse(addCourseShipRequest));
    }

    @ApiOperation("教师删除课程")
    @DeleteMapping(value = "teacher/delete/course/{id}")
    public SzpJsonResult<Integer> teacherDeleteCourse(@PathVariable(value = "id")Long id){
        return SzpJsonResult.ok(teachService.teacherDeleteCourse(id));
    }
}
