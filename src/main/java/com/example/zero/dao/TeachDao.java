package com.example.zero.dao;

import com.example.zero.mapper.TeachMapper;
import com.example.zero.pojo.Teach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-22 20:53.
 */
@Repository
public class TeachDao {
    @Autowired
    private TeachMapper teachMapper;

    public List<Teach> selectCourseByUserId(Long userId) {
        Example example = new Example(Teach.class);
        example.createCriteria()
                .andEqualTo("userId",userId);
        return teachMapper.selectByExample(example);
    }

    public Integer insert(Teach teach) {
        return teachMapper.insert(teach);
    }


    public Integer delete(Long id) {
        return teachMapper.deleteByPrimaryKey(id);
    }
}
