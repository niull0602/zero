package com.example.zero.controller;

import com.example.zero.common.SzpJsonResult;
import com.example.zero.request.AddCommunityRequest;
import com.example.zero.response.CommunityResponse;
import com.example.zero.response.CommunitySearchResponse;
import com.example.zero.service.CommunityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NiuLilu on 2020-06-02 19:34.
 */
@RestController
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    @ApiOperation("添加论坛")
    @PostMapping("/insert")
    public SzpJsonResult<Integer> insertCommunity(@RequestBody AddCommunityRequest addCommunityRequest) {
        return SzpJsonResult.ok(communityService.insertCommunity(addCommunityRequest));
    }

    @ApiOperation("查看所有论坛")
    @GetMapping("/find/all")
    public SzpJsonResult<CommunitySearchResponse> findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                          @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return SzpJsonResult.ok(communityService.findAll(page, size));

    }
    @ApiOperation("通过id查询详情")
    @GetMapping("/find/id")
    public SzpJsonResult<CommunityResponse> findById(@RequestParam(value = "id") Long id) {
        return SzpJsonResult.ok(communityService.findById(id));
    }

}
