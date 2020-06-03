package com.example.zero.dao;

import com.example.zero.mapper.ShipMapper;
import com.example.zero.pojo.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-31 11:06.
 */
@Repository
public class ShipDao {
    @Autowired
    private ShipMapper shipMapper;

    public Integer insert(Ship ship) {
        return shipMapper.insert(ship);
    }

    public List<Ship> getMessage(Long classId, Integer currentWeek) {
        Condition condition = new Condition(Ship.class);
        condition.createCriteria().andEqualTo("classId",classId)
                .andCondition("start_week <="+currentWeek+"  AND  end_week>="+currentWeek);
        return shipMapper.selectByExample(condition);
    }

    public List<Ship> getMessageByTeacher(Long userId, Integer currentWeek) {
        Condition condition = new Condition(Ship.class);
        condition.createCriteria().andEqualTo("userId",userId)
                .andCondition("start_week <="+currentWeek+"  AND  end_week>="+currentWeek);
        return shipMapper.selectByExample(condition);
    }
}
