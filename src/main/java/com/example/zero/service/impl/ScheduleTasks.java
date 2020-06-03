package com.example.zero.service.impl;

import com.example.zero.dao.PublishHomeworkDao;
import com.example.zero.service.PublishHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



/**
 * Created by NiuLilu on 2020-05-31 22:55.
 */
@Component
public class ScheduleTasks {
    @Autowired
    private PublishHomeworkDao publishHomeworkService;

    @Scheduled(fixedRate = 15*24*60*60*1000)
    public void reportCurrentTime(){
        publishHomeworkService.delete();
    }
}
