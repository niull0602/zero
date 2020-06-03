package com.example.zero.service;

import com.example.zero.request.ClassRequest;
import com.example.zero.response.ClassResponse;

/**
 * Created by NiuLilu on 2020-05-31 14:59.
 */
public interface ClassService {
    Integer add(ClassRequest classRequest);

    ClassResponse getAll(Integer pageNumber, Integer pageSize);
}
