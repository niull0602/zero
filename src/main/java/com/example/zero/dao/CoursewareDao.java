package com.example.zero.dao;

import com.example.zero.mapper.CoursewareMapper;
import com.example.zero.pojo.Courseware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-22 21:00.
 */
@Repository
public class CoursewareDao {
    @Autowired
    private CoursewareMapper coursewareMapper;

    public Integer insert(Courseware courseware) {
        return coursewareMapper.insert(courseware);
    }

    public Integer update(Courseware courseware) {
        return coursewareMapper.updateByPrimaryKeySelective(courseware);
    }

    public List<Courseware> selectByCourseId(Long courseId) {
        Example example = new Example(Courseware.class);
        example.createCriteria()
                .andEqualTo("courseId",courseId);
        return coursewareMapper.selectByExample(example);
    }
}
