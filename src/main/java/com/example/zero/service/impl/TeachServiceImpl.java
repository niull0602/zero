package com.example.zero.service.impl;

import com.example.zero.dao.TeachDao;
import com.example.zero.pojo.Teach;
import com.example.zero.request.AddCourseShipRequest;
import com.example.zero.service.TeachService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by NiuLilu on 2020-05-22 22:51.
 */
@Service
public class TeachServiceImpl implements TeachService {
    @Autowired
    private TeachDao teachDao;

    @Override
    public Integer teacherAddCourse(AddCourseShipRequest addCourseShipRequest) {
        Teach teach = new Teach();
        BeanUtils.copyProperties(addCourseShipRequest,teach);
        return teachDao.insert(teach);
    }

    @Override
    public Integer teacherDeleteCourse(Long id) {
        return teachDao.delete(id);
    }
}
