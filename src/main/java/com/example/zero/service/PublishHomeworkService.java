package com.example.zero.service;

import com.example.zero.request.AddPublishHomeworkRequest;
import com.example.zero.response.PublishHomeworkResponseList;

/**
 * Created by NiuLilu on 2020-05-31 15:25.
 */

public interface PublishHomeworkService {
    Integer add(AddPublishHomeworkRequest addPublishHomework);


   // PublishHomeworkResponseList getHomeworkByCoureId(Long courseId, Integer pageNumber, Integer pageSize);

    Integer delete();

    PublishHomeworkResponseList getHomeworkByClassId(Long classId, Integer pageNumber, Integer pageSize);
}
