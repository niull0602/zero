package com.example.zero.dao;

import com.example.zero.mapper.StudentClassMapper;
import com.example.zero.pojo.StudentClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

/**
 * Created by NiuLilu on 2020-05-31 11:25.
 */
@Repository
public class StudentClassDao {
    @Autowired
    private StudentClassMapper studentClassMapper;

    public StudentClass getStudentClass(Long userId) {
        Example example = new Example(StudentClass.class);
        example.createCriteria()
                .andEqualTo("userId",userId);
        return studentClassMapper.selectOneByExample(example);
    }

    public Integer add(StudentClass studentClass) {
        return studentClassMapper.insert(studentClass);
    }
}
