package com.example.zero.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-06-02 19:43.
 */
@Data
public class AddCommunityRequest {
    private Long userId;

    private Long classId;

    private String content;
}
