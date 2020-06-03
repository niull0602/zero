package com.example.zero.service.impl;

import com.example.zero.constant.Constant;
import com.example.zero.dao.HomeworkDao;
import com.example.zero.dao.PublishHomeworkDao;
import com.example.zero.dao.UserDao;
import com.example.zero.pojo.Homework;
import com.example.zero.pojo.PublishHomework;
import com.example.zero.pojo.User;
import com.example.zero.request.*;
import com.example.zero.response.HomeworkResponse;
import com.example.zero.response.HomeworkResponseList;
import com.example.zero.service.HomeworkService;
import com.example.zero.utils.DateTimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by NiuLilu on 2020-05-22 21:14.
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    private HomeworkDao homeworkDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PublishHomeworkDao publishHomeworkDao;
    @Transactional
    @Override
    public Integer uploadHomerWork(AddHomerworkRequest addHomerworkRequest) {
        Homework homework = new Homework();
        BeanUtils.copyProperties(addHomerworkRequest,homework);
        homework.setCreateTime(new Date());
        homework.setUpdateTime(new Date());
        homework.setMark(Constant.FINISH);
        return homeworkDao.insert(homework);
    }

    @Override
    public HomeworkResponseList downloadHomerWork(DownloadHomeworkRequest downloadHomeworkRequest) {
        HomeworkResponseList homeworkResponseList = new HomeworkResponseList();
        PageHelper.startPage(downloadHomeworkRequest.getPageNumber(),downloadHomeworkRequest.getPageSize());
        List<Homework> homeworkList = homeworkDao.selectHomework(downloadHomeworkRequest.getCourseId());
        PageInfo<Homework> homeworkPageInfo = new PageInfo<>(homeworkList);
        List<HomeworkResponse> responseList = new ArrayList<>();
        for (Homework homework:homeworkPageInfo.getList()){
            HomeworkResponse homeworkResponse = new HomeworkResponse();
            BeanUtils.copyProperties(homework,homeworkResponse);
            homeworkResponse.setCreateTime(DateTimeUtil.getDateTimeToString(homework.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            User user = userDao.selectUser(homework.getUserId());
            homeworkResponse.setUser(user);
            responseList.add(homeworkResponse);
        }
        homeworkResponseList.setTotal(homeworkPageInfo.getTotal());
        return homeworkResponseList;
    }

    @Override
    public Integer updateHomeWork(UpdateHomerworkRequest addHomerworkRequest) {
        Homework homework = new Homework();
        BeanUtils.copyProperties(addHomerworkRequest,homework);
        homework.setUpdateTime(new Date());
        return homeworkDao.update(homework);
    }

    @Override
    public HomeworkResponseList selectAllHomework(DownloadHomeworkRequest selectRequest) {
        HomeworkResponseList homeworkResponseList = new HomeworkResponseList();
        PageHelper.startPage(selectRequest.getPageNumber(),selectRequest.getPageSize());
        List<Homework> homeworkList = homeworkDao.selectAllHomework(selectRequest.getCourseId());
        PageInfo<Homework> homeworkPageInfo = new PageInfo<>(homeworkList);
        List<HomeworkResponse> responseList = new ArrayList<>();
        for (Homework homework:homeworkPageInfo.getList()){
            HomeworkResponse homeworkResponse = new HomeworkResponse();
            BeanUtils.copyProperties(homework,homeworkResponse);
            homeworkResponse.setCreateTime(DateTimeUtil.getDateTimeToString(homework.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            User user = userDao.selectUser(homework.getUserId());
            homeworkResponse.setUser(user);
            responseList.add(homeworkResponse);
        }
        homeworkResponseList.setTotal(homeworkPageInfo.getTotal());
        return homeworkResponseList;
    }

    @Override
    public HomeworkResponseList selectAllHomeworkByUserId(SelectUserHomeworkRequest selectRequest) {
        HomeworkResponseList homeworkResponseList = new HomeworkResponseList();
        PageHelper.startPage(selectRequest.getPageNumber(),selectRequest.getPageSize());
        List<Homework> homeworkList = homeworkDao.selectAllHomeworkByUserId(selectRequest.getUserId());
        PageInfo<Homework> homeworkPageInfo = new PageInfo<>(homeworkList);
        List<HomeworkResponse> responseList = new ArrayList<>();
        for (Homework homework:homeworkPageInfo.getList()){
            HomeworkResponse homeworkResponse = new HomeworkResponse();
            BeanUtils.copyProperties(homework,homeworkResponse);
            homeworkResponse.setCreateTime(DateTimeUtil.getDateTimeToString(homework.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            User user = userDao.selectUser(homework.getUserId());
            homeworkResponse.setUser(user);
            responseList.add(homeworkResponse);
        }
        homeworkResponseList.setList(responseList);
        homeworkResponseList.setTotal(homeworkPageInfo.getTotal());
        return homeworkResponseList;
    }

    @Override
    public HomeworkResponseList getHomeworkByClassId(Long userId,Long classId,Short mark, Integer pageNumber, Integer pageSize) {
        HomeworkResponseList homeworkResponseList= new HomeworkResponseList();
        PageHelper.startPage(pageNumber,pageSize);
        List<Homework> homeworkList = homeworkDao.getHomeworkByClassId(userId,classId,mark);
        PageInfo<Homework> pageInfo = new PageInfo<>(homeworkList);
        List<HomeworkResponse> responseList=new ArrayList<>();
        for (Homework homework:pageInfo.getList()){
            HomeworkResponse homeworkResponse = new HomeworkResponse();
            homeworkResponse.setCreateTime(DateTimeUtil.getDateTimeToString(homework.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            User user = userDao.selectUser(homework.getUserId());
            PublishHomework publishHomework = publishHomeworkDao.getHomeworkById(homework.getPublishId());
            if(publishHomework!=null) {
                homeworkResponse.setHomeworkName(publishHomework.getHomeworkName());
                homeworkResponse.setContent(publishHomework.getContent());
            }
            homeworkResponse.setUser(user);
            BeanUtils.copyProperties(homework,homeworkResponse);
            responseList.add(homeworkResponse);
        }
        homeworkResponseList.setList(responseList);
        homeworkResponseList.setTotal(pageInfo.getTotal());
        return homeworkResponseList;
    }
}
