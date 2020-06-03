package com.example.zero.service;

import com.example.zero.request.AddCommunityRequest;
import com.example.zero.response.CommunityResponse;
import com.example.zero.response.CommunitySearchResponse;

/**
 * Created by NiuLilu on 2020-06-02 19:34.
 */
public interface CommunityService {
    Integer insertCommunity(AddCommunityRequest addCommunityRequest);

    CommunityResponse findById(Long id);

    CommunitySearchResponse findAll(Integer page, Integer size);

}
