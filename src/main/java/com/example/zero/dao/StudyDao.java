package com.example.zero.dao;

import com.example.zero.mapper.StudyMapper;
import com.example.zero.pojo.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-22 20:54.
 */
@Repository
public class StudyDao {
    @Autowired
    private StudyMapper studyMapper;

    public List<Study> selectCourseByUserId(Long userId) {
        Example example = new Example(Study.class);
        example.createCriteria()
                .andEqualTo("userId",userId);
        return studyMapper.selectByExample(example);
    }

    public Integer insert(Study study) {
        return studyMapper.insert(study);
    }

    public Integer delete(Long id) {
        return studyMapper.deleteByPrimaryKey(id);
    }
}
