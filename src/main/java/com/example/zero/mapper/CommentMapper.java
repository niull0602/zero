package com.example.zero.mapper;

import com.example.zero.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends CommonMapper<Comment> {
}