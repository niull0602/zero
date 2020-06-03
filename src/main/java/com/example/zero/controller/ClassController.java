package com.example.zero.controller;

import com.example.zero.common.SzpJsonResult;
import com.example.zero.request.ClassRequest;
import com.example.zero.response.ClassResponse;
import com.example.zero.service.ClassService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NiuLilu on 2020-05-31 14:59.
 */
@RestController
public class ClassController {
    @Autowired
    private ClassService classService;
    @ApiOperation("添加班级")
    @PostMapping(value = "post/class")
    public SzpJsonResult<Integer> postClass(@RequestBody ClassRequest classRequest){
        return SzpJsonResult.ok(classService.add(classRequest));
    }
    @ApiOperation("获取所有的班级")
    @GetMapping(value = "get/all/class")
    public SzpJsonResult<ClassResponse> getAllClass(@RequestParam(value = "pageNumber",defaultValue = "1")Integer pageNumber,
                                                    @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        return SzpJsonResult.ok(classService.getAll(pageNumber,pageSize));
    }

}
