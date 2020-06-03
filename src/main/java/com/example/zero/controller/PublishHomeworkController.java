package com.example.zero.controller;

import com.example.zero.common.SzpJsonResult;
import com.example.zero.request.AddPublishHomeworkRequest;
import com.example.zero.response.HomeworkResponseList;
import com.example.zero.response.PublishHomeworkResponseList;
import com.example.zero.service.PublishHomeworkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NiuLilu on 2020-05-31 15:24.
 */
@RestController
public class PublishHomeworkController {
    @Autowired
    private PublishHomeworkService publishHomeworkService;
    @ApiOperation("发布作业")
    @PostMapping(value = "teacher/post/homework")
    public SzpJsonResult<Integer> teacherPostHomework(@RequestBody AddPublishHomeworkRequest addPublishHomework){
        return SzpJsonResult.ok(publishHomeworkService.add(addPublishHomework));
    }

    @ApiOperation("学生通过班级查看作业")
    @GetMapping(value = "get/publishhomework/classId")
    public SzpJsonResult<PublishHomeworkResponseList> getPublishHomeworkByClassId(@RequestParam(value = "classId")Long classId,
                                                                    @RequestParam(value = "pageNumber",defaultValue = "1",required = false)Integer pageNumber,
                                                                    @RequestParam(value = "pageSize",defaultValue = "10",required = false)Integer pageSize){
        return SzpJsonResult.ok(publishHomeworkService.getHomeworkByClassId(classId,pageNumber,pageSize));
    }

}
