package com.example.zero.service.impl;

import com.example.zero.dao.PublishHomeworkDao;
import com.example.zero.pojo.PublishHomework;
import com.example.zero.request.AddPublishHomeworkRequest;
import com.example.zero.response.PublishHomeworkResponse;
import com.example.zero.response.PublishHomeworkResponseList;
import com.example.zero.service.PublishHomeworkService;
import com.example.zero.utils.DateTimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by NiuLilu on 2020-05-31 15:25.
 */
@Service
public class PublishHomeworkServiceImpl implements PublishHomeworkService {
    @Autowired
    private PublishHomeworkDao publishHomeworkDao;

    @Override
    public Integer add(AddPublishHomeworkRequest addPublishHomework) {
        PublishHomework publishHomework = new PublishHomework();
        BeanUtils.copyProperties(addPublishHomework,publishHomework);
        publishHomework.setCreateTime(new Date());
        return publishHomeworkDao.insert(publishHomework);
    }

    @Override
    public PublishHomeworkResponseList getHomeworkByClassId(Long courseId, Integer pageNumber, Integer pageSize) {
        PublishHomeworkResponseList publishHomeworkResponseList = new PublishHomeworkResponseList();
        PageHelper.startPage(pageNumber,pageSize);
        List<PublishHomework> homeworkList = publishHomeworkDao.getHomeworkByClassId(courseId);
        PageInfo<PublishHomework> pageInfo = new PageInfo<>(homeworkList);
        List<PublishHomeworkResponse> list = new ArrayList<>();
        for (PublishHomework publishHomework:pageInfo.getList()){
            PublishHomeworkResponse publishHomeworkResponse = new PublishHomeworkResponse();
            BeanUtils.copyProperties(publishHomework,publishHomeworkResponse);
            publishHomeworkResponse.setTeacherName(DateTimeUtil.getDateTimeToString(publishHomework.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            list.add(publishHomeworkResponse);
        }
        publishHomeworkResponseList.setList(list);
        publishHomeworkResponseList.setTotal(pageInfo.getTotal());
        return publishHomeworkResponseList;
    }

    @Override
    public Integer delete() {
        return publishHomeworkDao.delete();
    }
}
