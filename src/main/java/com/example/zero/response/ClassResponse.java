package com.example.zero.response;

import com.example.zero.pojo.Class;
import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-31 15:04.
 */
@Data
public class ClassResponse {
    private List<Class> list;

    private Long total;


}
