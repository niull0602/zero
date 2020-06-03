package com.example.zero.controller;

import com.example.zero.common.SzpJsonResult;
import com.example.zero.request.AddCoursewareRequest;
import com.example.zero.request.SelectCoursewareRequest;
import com.example.zero.request.UpdateCoursewareRequest;
import com.example.zero.response.CoursewareReponseList;
import com.example.zero.service.CoursewareService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NiuLilu on 2020-05-22 21:14.
 */
@RestController
public class CoursewareController {
    @Autowired
    private CoursewareService coursewareService;

    @ApiOperation("老师上传课件")
    @PostMapping(value = "upload/courseware")
    public SzpJsonResult<Integer> uploadCourseware(@RequestBody AddCoursewareRequest addCoursewareRequest){
        return SzpJsonResult.ok(coursewareService.uploadCourseware(addCoursewareRequest));
    }

    @ApiOperation("更新课件")
    @PutMapping(value = "update/courseware")
    public SzpJsonResult<Integer> updateCourseware(@RequestBody UpdateCoursewareRequest addCoursewareRequest){
        return SzpJsonResult.ok(coursewareService.updateCourseware(addCoursewareRequest));
    }

    @ApiOperation("学生查看课件")
    @PostMapping(value = "download/courseware")
    public SzpJsonResult<CoursewareReponseList> downloadCourseware(@RequestBody SelectCoursewareRequest selectCoursewareRequest){
        return SzpJsonResult.ok(coursewareService.downloadCourseware(selectCoursewareRequest));
    }
}
