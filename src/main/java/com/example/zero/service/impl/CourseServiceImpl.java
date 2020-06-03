package com.example.zero.service.impl;

import com.example.zero.dao.*;
import com.example.zero.pojo.*;
import com.example.zero.request.*;
import com.example.zero.response.*;
import com.example.zero.service.CourseService;
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
 * Created by NiuLilu on 2020-05-22 16:12.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private StudyDao studyDao;
    @Autowired
    private ClassDao classDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ShipDao shipDao;

    @Transactional
    @Override
    public Integer addCourse(AddCourseRequest addCourseRequest) {
        Course course = new Course();
        BeanUtils.copyProperties(addCourseRequest, course);
        course.setCreateTime(new Date());
        course.setUpdateTime(new Date());
        Ship ship = new Ship();
        BeanUtils.copyProperties(addCourseRequest, ship);
        shipDao.insert(ship);
        return courseDao.addCourse(course);
    }

    @Override
    public Integer deleteCourseById(Long id) {
        return courseDao.deleteById(id);
    }

    @Override
    public Integer updateteCourseById(UpdateCourseRequest updateCourseRequest) throws Exception {
        Course course = new Course();
        BeanUtils.copyProperties(updateCourseRequest, course);
        course.setUpdateTime(new Date());
        return courseDao.updateCourseById(course);
    }

    @Override
    public CourseResponse selectAllCourse(SelectRequest selectRequest) {
        PageHelper.startPage(selectRequest.getPageNumber(), selectRequest.getPageSize());
        List<Course> courseList = courseDao.selectAll();
        PageInfo<Course> coursePageInfo = new PageInfo<>(courseList);
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setList(coursePageInfo.getList());
        courseResponse.setTotal(coursePageInfo.getTotal());
        return courseResponse;
    }

    @Override
    public CourseResponse findCourseByKeyword(SearchCourseRequest selectRequest) {
        PageHelper.startPage(selectRequest.getPageNumber(), selectRequest.getPageSize());
        List<Course> courseList = courseDao.findCourseByKeyword(selectRequest.getKeyword());
        PageInfo<Course> coursePageInfo = new PageInfo<>(courseList);
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setList(coursePageInfo.getList());
        courseResponse.setTotal(coursePageInfo.getTotal());
        return courseResponse;
    }

    @Override
    public ClassCourseResponse selectStudentCourse(StudentSelectCourseRequest selectRequest) {
        //PageHelper.startPage(selectRequest.getPageNumber(),selectRequest.getPageSize());
        ClassCourseResponse classCourseResponse = new ClassCourseResponse();
        List<Ship> message = shipDao.getMessage(selectRequest.getClassId(), selectRequest.getCurrentWeek());
        List<StudentCourseResponse> list = new ArrayList<>();
        for (Ship ship:message){
            StudentCourseResponse studentCourseResponse = new StudentCourseResponse();
            Course course = courseDao.getCourseById(ship.getCourseId());
            if (course!=null)
            BeanUtils.copyProperties(course,studentCourseResponse);
            BeanUtils.copyProperties(ship,studentCourseResponse);
            studentCourseResponse.setName(userDao.selectUser(ship.getUserId()).getName());
            list.add(studentCourseResponse);
        }
        classCourseResponse.setList(list);
        return classCourseResponse;
    }

    @Override
    public TeacherClassCourseResponseList selectTeacherCourse(TeacherSelectRequest selectRequest) {
        //PageHelper.startPage(selectRequest.getPageNumber(), selectRequest.getPageSize());
        TeacherClassCourseResponseList teacherClassCourseResponseList = new TeacherClassCourseResponseList();
        List<TeacherClassCourseResponse> list = new ArrayList<>();
        List<Ship> message = shipDao.getMessageByTeacher(selectRequest.getUserId(),selectRequest.getCurrentWeek());
        for (Ship ship:message){
            TeacherClassCourseResponse teacherClassCourseResponse = new TeacherClassCourseResponse();
            Course course = courseDao.getCourseById(ship.getCourseId());
            if (course!=null)
                BeanUtils.copyProperties(course,teacherClassCourseResponse);
            teacherClassCourseResponse.setClassName(classDao.getClassDesc(ship.getClassId()).getClassName());
            BeanUtils.copyProperties(ship,teacherClassCourseResponse);
            list.add(teacherClassCourseResponse);
        }
        teacherClassCourseResponseList.setList(list);
        return teacherClassCourseResponseList;
    }
}
