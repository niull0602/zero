package com.example.zero.controller;

import com.example.zero.common.SzpJsonResult;
import com.example.zero.request.*;
import com.example.zero.response.HomeworkResponse;
import com.example.zero.response.HomeworkResponseList;
import com.example.zero.response.PublishHomeworkResponseList;
import com.example.zero.service.HomeworkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NiuLilu on 2020-05-22 21:02.
 */
@RestController
public class HomeWorkController {
    @Autowired
    private HomeworkService homeworkService;

    @ApiOperation("学生上传作业,文件<5M")
    @PostMapping(value = "upload/homework")
    public SzpJsonResult<Integer> uploadHomeWork(@RequestBody AddHomerworkRequest addHomerworkRequest){
        return SzpJsonResult.ok(homeworkService.uploadHomerWork(addHomerworkRequest));
    }

    @ApiOperation("老师下载查看作业")
    @PostMapping(value = "download/homerwork")
    public SzpJsonResult<HomeworkResponseList> downloadHomework(@RequestBody DownloadHomeworkRequest downloadHomeworkRequest) throws Exception {
        return SzpJsonResult.ok(homeworkService.downloadHomerWork(downloadHomeworkRequest));
    }

    @ApiOperation("更新mark")
    @PostMapping(value = "update/homework")
    public SzpJsonResult<Integer> updateHomeWork(@RequestBody UpdateHomerworkRequest addHomerworkRequest){
        return SzpJsonResult.ok(homeworkService.updateHomeWork(addHomerworkRequest));
    }

    @ApiOperation("老师查看所有作业")
    @PostMapping(value = "select/all/homerwork")
    public SzpJsonResult<HomeworkResponseList> selectAllHomework(@RequestBody DownloadHomeworkRequest selectRequest)  {
        return SzpJsonResult.ok(homeworkService.selectAllHomework(selectRequest));
    }

    @ApiOperation("老师一个学生查看所有作业")
    @PostMapping(value = "select/all/homerwork/userId")
    public SzpJsonResult<HomeworkResponseList> selectAllHomeworkByUserId(@RequestBody SelectUserHomeworkRequest selectRequest)  {
        return SzpJsonResult.ok(homeworkService.selectAllHomeworkByUserId(selectRequest));
    }

    @ApiOperation("学生通过班级查看作业")
    @GetMapping(value = "get/homework/classId")
    public SzpJsonResult<HomeworkResponseList> getHomeworkByClassId(@RequestParam(value = "classId")Long classId,
                                                                    @RequestParam(value = "userId")Long userId,
                                                                    @RequestParam(value = "mark")Short mark,
                                                                    @RequestParam(value = "pageNumber",defaultValue = "1",required = false)Integer pageNumber,
                                                                    @RequestParam(value = "pageSize",defaultValue = "10",required = false)Integer pageSize){
        return SzpJsonResult.ok(homeworkService.getHomeworkByClassId(userId,classId,mark,pageNumber,pageSize));
    }
}
