package com.example.zero.service.impl;

import com.example.zero.dao.CommentDao;
import com.example.zero.dao.UserDao;
import com.example.zero.pojo.Comment;
import com.example.zero.pojo.User;
import com.example.zero.request.AddCommentRequest;
import com.example.zero.response.CommentResponse;
import com.example.zero.service.CommentService;
import com.example.zero.utils.DateTimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by NiuLilu on 2020-06-02 19:53.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<CommentResponse> findCommentByCommuntyId(Integer page, Integer size, Long communityId) {
        List<CommentResponse> oneCommentResponseList = new ArrayList<>();
        List<Comment>  oneCommentsList= commentDao.findCommentsByCommunityId(communityId);
        for (Comment oneComments:oneCommentsList){
            CommentResponse oneCommentResponse = new CommentResponse();
            User user = userDao.selectUser(oneComments.getUserId());
            BeanUtils.copyProperties(user,oneCommentResponse);
            BeanUtils.copyProperties(oneComments,oneCommentResponse);
            oneCommentResponse.setCreateTime(DateTimeUtil.getDateTimeToString(oneComments.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            oneCommentResponseList.add(oneCommentResponse);
        }
        return oneCommentResponseList;
    }

    @Override
    public Integer insert(AddCommentRequest addOneCommentRequest) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(addOneCommentRequest,comment);
        comment.setCreateTime(new Date());
        return commentDao.add(comment);
    }
}
