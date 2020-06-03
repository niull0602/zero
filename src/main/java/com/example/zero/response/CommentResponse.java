package com.example.zero.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by NiuLilu on 2020-06-02 19:47.
 */
@Data
public class CommentResponse {
    private Long id;

    private Long communityId;

    private String content;
    @ApiModelProperty(value = "发表时间")
    private String createTime;

    private Long userId;

    private String name;

    private String accountNumber;
}
