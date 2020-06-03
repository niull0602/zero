package com.example.zero.mapper;

import com.example.zero.pojo.PublishHomework;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PublishHomeworkMapper extends CommonMapper<PublishHomework> {
    Integer deleteAll();

}