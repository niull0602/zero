package com.example.zero.service.impl;

import com.example.zero.dao.StudentClassDao;
import com.example.zero.pojo.StudentClass;
import com.example.zero.request.PostStudentToClassRequest;
import com.example.zero.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by NiuLilu on 2020-05-31 14:45.
 */
@Service
public class StudentClassServiceImpl implements StudentClassService {
    @Autowired
    private StudentClassDao studentClassDao;

    @Override
    public Integer add(PostStudentToClassRequest postStudentToClass) {
        StudentClass studentClass = new StudentClass();
        studentClass.setUserId(postStudentToClass.getUserId());
        studentClass.setClassId(postStudentToClass.getClassId());
        return studentClassDao.add(studentClass);
    }
}
