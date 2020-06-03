package com.example.zero.dao;

import com.example.zero.mapper.PublishHomeworkMapper;
import com.example.zero.pojo.PublishHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-31 15:26.
 */
@Repository
public class PublishHomeworkDao {
    @Autowired
    private PublishHomeworkMapper publishHomeworkMapper;


    public Integer insert(PublishHomework publishHomework) {
        return publishHomeworkMapper.insert(publishHomework);
    }

    public List<PublishHomework> getHomeworkByClassId(Long classId) {
        Example example = new Example(PublishHomework.class);
        example.createCriteria()
                .andEqualTo("classId",classId);
        return publishHomeworkMapper.selectByExample(example);
    }

    public Integer delete() {
        return publishHomeworkMapper.deleteAll();
    }

    public PublishHomework getHomeworkById(Long publishId) {
        return publishHomeworkMapper.selectByPrimaryKey(publishId);
    }
}
