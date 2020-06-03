package com.example.zero.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-06-02 20:04.
 */
@Data
public class AddCommentRequest {
    private Long userId;

    private Long communityId;

    private String content;
}
