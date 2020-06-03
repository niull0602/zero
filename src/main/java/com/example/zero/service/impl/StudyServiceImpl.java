package com.example.zero.service.impl;

import com.example.zero.dao.StudyDao;
import com.example.zero.pojo.Study;
import com.example.zero.request.AddCourseShipRequest;
import com.example.zero.service.StudyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by NiuLilu on 2020-05-22 23:05.
 */
@Service
public class StudyServiceImpl implements StudyService {
    @Autowired
    private StudyDao studyDao;

    @Override
    public Integer studentAddCourse(AddCourseShipRequest addCourseShipRequest) {
        Study study = new Study();
        BeanUtils.copyProperties(addCourseShipRequest,study);
        return studyDao.insert(study);
    }

    @Override
    public Integer studentDeleteCourse(Long id) {
        return studyDao.delete(id);
    }
}
