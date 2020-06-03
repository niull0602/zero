package com.example.zero.dao;

import com.example.zero.constant.Constant;
import com.example.zero.mapper.HomeworkMapper;
import com.example.zero.pojo.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-22 21:00.
 */
@Repository
public class HomeworkDao {
    @Autowired
    private HomeworkMapper homeworkMapper;

    public Integer insert(Homework homework) {
        return homeworkMapper.insert(homework);
    }

    public List<Homework> selectHomework(Long courseId) {
        Example example = new Example(Homework.class);
        example.createCriteria()
                .andEqualTo("courseId",courseId)
                .andEqualTo("mark", Constant.NOT_DOWNLOAD);
        return homeworkMapper.selectByExample(example);
    }

    public List<Homework> selectAllHomework(Long courseId) {
        Example example = new Example(Homework.class);
        example.createCriteria()
                .andEqualTo("courseId",courseId);
        return homeworkMapper.selectByExample(example);
    }

    public List<Homework> selectAllHomeworkByUserId(Long userId) {
        Example example = new Example(Homework.class);
        example.createCriteria()
                .andEqualTo("userId",userId);
        return homeworkMapper.selectByExample(example);
    }

    public Integer update(Homework homework) {
        return homeworkMapper.updateByPrimaryKeySelective(homework);
    }

    public List<Homework> getHomeworkByClassId(Long userId,Long classId,Short mark) {
        Example example = new Example(Homework.class);
        example.createCriteria()
                .andEqualTo("userId",userId)
                .andEqualTo("classId",classId)
                .andEqualTo("mark",mark);
        return homeworkMapper.selectByExample(example);
    }
}
