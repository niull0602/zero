package com.example.zero.controller;

import com.example.zero.common.SzpJsonResult;
import com.example.zero.request.AddCommentRequest;
import com.example.zero.service.CommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NiuLilu on 2020-06-02 19:53.
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ApiOperation("添加留言")
    @PostMapping("post/comment")
    public SzpJsonResult<Integer> insert(@RequestBody AddCommentRequest addOneCommentRequest) {
        return SzpJsonResult.ok(commentService.insert(addOneCommentRequest));
    }
}
