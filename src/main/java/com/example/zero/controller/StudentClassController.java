package com.example.zero.controller;

import com.example.zero.common.SzpJsonResult;
import com.example.zero.request.PostStudentToClassRequest;
import com.example.zero.service.StudentClassService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NiuLilu on 2020-05-31 14:44.
 */
@RestController
public class StudentClassController {
    @Autowired
    private StudentClassService studentClassService;
    @ApiOperation("加入班级")
    @PostMapping("post/student/class")
    public SzpJsonResult<Integer> postStudentToClass(@RequestBody PostStudentToClassRequest postStudentToClass){
        return SzpJsonResult.ok(studentClassService.add(postStudentToClass));
    }
}
