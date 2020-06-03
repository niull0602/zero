package com.example.zero.dao;

import com.example.zero.mapper.ClassMapper;
import com.example.zero.pojo.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-31 11:22.
 */
@Repository
public class ClassDao {
    @Autowired
    private ClassMapper classMapper;

    public Class getClassDesc(Long classId) {
        return classMapper.selectByPrimaryKey(classId);
    }

    public Integer insert(Class aClass) {
        return classMapper.insert(aClass);
    }

    public List<Class> getAll() {
        return classMapper.selectAll();
    }
}
