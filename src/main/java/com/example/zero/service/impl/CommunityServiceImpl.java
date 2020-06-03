package com.example.zero.service.impl;

import com.example.zero.dao.CommunityDao;
import com.example.zero.dao.UserDao;
import com.example.zero.pojo.Community;
import com.example.zero.pojo.User;
import com.example.zero.request.AddCommunityRequest;
import com.example.zero.response.CommentResponse;
import com.example.zero.response.CommunityResponse;
import com.example.zero.response.CommunitySearchResponse;
import com.example.zero.service.CommentService;
import com.example.zero.service.CommunityService;
import com.example.zero.utils.DateTimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by NiuLilu on 2020-06-02 19:35.
 */
@Service
@Slf4j
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    private CommunityDao communityDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommentService commentService;

    @Override
    public Integer insertCommunity(AddCommunityRequest addCommunityRequest) {
        Community community = new Community();
        BeanUtils.copyProperties(addCommunityRequest, community);
        community.setCreateTime(new Date());
        return communityDao.insertCommunity(community);
    }

    @Override
    public CommunityResponse findById(Long id) {
        Community community = communityDao.findById(id);
        CommunityResponse communityResponse = new CommunityResponse();
        Long userId = community.getUserId();
        User user = userDao.selectUser(userId);
        BeanUtils.copyProperties(user,communityResponse);
        communityResponse.setContent(community.getContent());
        communityResponse.setId(community.getId());
        communityResponse.setCreateTime(DateTimeUtil.getDateTimeToString(community.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
        List<CommentResponse> oneCommentResponses = commentService.findCommentByCommuntyId(1,10,community.getId());
        communityResponse.setCommentResponseList(oneCommentResponses);
        return communityResponse;
    }

    @Override
    public CommunitySearchResponse findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Community> communityList = communityDao.findAll();//不在dao层分页了
        log.info("数据库查询的communityList-{}", communityList);
        PageInfo<Community> communityPageInfo = new PageInfo<>(communityList);
        List<Community> list = communityPageInfo.getList();
        log.info("pageInfo的communityList-{}", list);
        List<CommunityResponse> communityResponseList = new ArrayList<>();
        for (Community community : list) {
            CommunityResponse communityResponse = new CommunityResponse();
            BeanUtils.copyProperties(community, communityResponse);
            User user = userDao.selectUser(community.getUserId());
            BeanUtils.copyProperties(user, communityResponse);
            communityResponse.setId(community.getId());
            communityResponse.setCreateTime(DateTimeUtil.getDateTimeToString(community.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            communityResponseList.add(communityResponse);
        }
        return getCommunitySearchResponse(communityResponseList);
    }

    public CommunitySearchResponse getCommunitySearchResponse(List<CommunityResponse> communityResponseList) {
        CommunitySearchResponse communitySearchResponse = new CommunitySearchResponse();
        communitySearchResponse.setList(communityResponseList);
        communitySearchResponse.setTotal((long) communityResponseList.size());
        return communitySearchResponse;
    }

}
