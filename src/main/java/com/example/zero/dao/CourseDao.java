package com.example.zero.dao;

import com.example.zero.mapper.CourseMapper;
import com.example.zero.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-22 16:10.
 */
@Repository
public class CourseDao {
    @Autowired
    private CourseMapper courseMapper;

    public Integer addCourse(Course course) {
        return courseMapper.insert(course);
    }

    public Integer deleteById(Long id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteByIds(List<Long> ids) {
        Example example = new Example(Course.class);
        example.createCriteria()
                .andIn("id",ids);
        return courseMapper.deleteByExample(ids);
    }

    public Integer updateCourseById(Course c) {
        return courseMapper.updateByPrimaryKeySelective(c);
    }

    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }

    public List<Course> findCourseByKeyword(String keyword) {
        Example example = new Example(Course.class);
        example.createCriteria()
                .andLike("courceName","%"+keyword+"%");
        return courseMapper.selectByExample(example);
    }

    public Course selectCourseById(Long courseId) {
        return courseMapper.selectByPrimaryKey(courseId);
    }

    public Course getCourseById(Long classId) {
        return courseMapper.selectByPrimaryKey(classId);
    }
}
