package com.example.zero.service;

import com.example.zero.request.AddCommentRequest;
import com.example.zero.response.CommentResponse;

import java.util.List;

/**
 * Created by NiuLilu on 2020-06-02 19:53.
 */
public interface CommentService {
    List<CommentResponse> findCommentByCommuntyId(Integer page, Integer size,Long communityId);

    Integer insert(AddCommentRequest addOneCommentRequest);

}
