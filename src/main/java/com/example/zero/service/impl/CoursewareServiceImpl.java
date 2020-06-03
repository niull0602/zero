package com.example.zero.service.impl;

import com.example.zero.request.SelectCoursewareRequest;
import com.example.zero.dao.CoursewareDao;
import com.example.zero.dao.UserDao;
import com.example.zero.pojo.Courseware;
import com.example.zero.pojo.User;
import com.example.zero.request.AddCoursewareRequest;
import com.example.zero.request.UpdateCoursewareRequest;
import com.example.zero.response.CoursewareReponse;
import com.example.zero.response.CoursewareReponseList;
import com.example.zero.service.CoursewareService;
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
 * Created by NiuLilu on 2020-05-22 21:15.
 */
@Service
@Slf4j
public class CoursewareServiceImpl implements CoursewareService {
    @Autowired
    private CoursewareDao coursewareDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Integer uploadCourseware(AddCoursewareRequest addCoursewareRequest) {
        Courseware courseware = new Courseware();
        BeanUtils.copyProperties(addCoursewareRequest,courseware);
        courseware.setCreateTime(new Date());
        courseware.setUpdateTime(new Date());
        return coursewareDao.insert(courseware);
    }

    @Override
    public Integer updateCourseware(UpdateCoursewareRequest addCoursewareRequest) {
        Courseware courseware = new Courseware();
        BeanUtils.copyProperties(addCoursewareRequest,courseware);
        courseware.setUpdateTime(new Date());
        return coursewareDao.update(courseware);
    }

    @Override
    public CoursewareReponseList downloadCourseware(SelectCoursewareRequest selectCoursewareRequest) {
        CoursewareReponseList coursewareReponseList = new CoursewareReponseList();
        PageHelper.startPage(selectCoursewareRequest.getPageNumber(),selectCoursewareRequest.getPageSize());
        List<Courseware> coursewareList = coursewareDao.selectByCourseId(selectCoursewareRequest.getCourseId());
        PageInfo<Courseware> pageInfo = new PageInfo<>(coursewareList);
        List<CoursewareReponse> coursewareReponses = new ArrayList<>();
        for (Courseware courseware:pageInfo.getList()){
            CoursewareReponse courseResponse = new CoursewareReponse();
            BeanUtils.copyProperties(courseware,courseResponse);
            User user = userDao.selectUser(courseware.getUserId());
            courseResponse.setUser(user);
            coursewareReponses.add(courseResponse);
        }
        coursewareReponseList.setList(coursewareReponses);
        coursewareReponseList.setTotal(pageInfo.getTotal());
        return coursewareReponseList;
    }
}
