package com.example.zero.mapper;

import com.example.zero.pojo.Homework;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface HomeworkMapper extends CommonMapper<Homework> {
    List<Homework> selectHomeworkByCourseIdAndDate(@Param(value = "courseId")Long courseId, @Param(value = "createTime")Date createTime);
}