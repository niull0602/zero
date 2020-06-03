package com.example.zero.dao;

import com.example.zero.mapper.CommentMapper;
import com.example.zero.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Created by NiuLilu on 2020-06-02 19:54.
 */
@Repository
public class CommentDao {
    @Autowired
    private CommentMapper commentMapper;
    public List<Comment> findCommentsByCommunityId(Long communityId) {
        Condition condition = new Condition(Comment.class);
        condition.createCriteria().andEqualTo("communityId",communityId);
        condition.setOrderByClause("create_time desc");
        return commentMapper.selectByExample(condition);
    }

    public Integer add(Comment comment) {
        return commentMapper.insert(comment);
    }
}
