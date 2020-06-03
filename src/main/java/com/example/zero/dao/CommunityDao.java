package com.example.zero.dao;

import com.example.zero.mapper.CommunityMapper;
import com.example.zero.pojo.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by NiuLilu on 2020-06-02 19:36.
 */
@Repository
public class CommunityDao {
    @Autowired
    private CommunityMapper communityMapper;

    public List<Community> findAll() {
        Condition condition = new Condition(Community.class);
        condition.setOrderByClause("create_time desc");
        return communityMapper.selectByExample(condition);
    }

    public Community findById(Long id) {
        return communityMapper.selectByPrimaryKey(id);
    }

    public Integer insertCommunity(Community community) {
        return communityMapper.insert(community);
    }

    public List<Community> selectByUserId(Long userId) {
        Example example = new Example(Community.class);
        example.createCriteria()
                .andEqualTo("userId", userId);
        return communityMapper.selectByExample(example);
    }
}
