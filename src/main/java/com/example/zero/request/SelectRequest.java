package com.example.zero.request;

import lombok.Data;

/**
 * Created by NiuLilu on 2020-05-22 13:43.
 */
@Data
public class SelectRequest {
    private Integer pageNumber=1;
    private Integer pageSize=10;
}
