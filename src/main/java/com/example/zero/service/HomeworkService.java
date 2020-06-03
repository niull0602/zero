package com.example.zero.service;

import com.example.zero.request.*;
import com.example.zero.response.HomeworkResponseList;

/**
 * Created by NiuLilu on 2020-05-22 21:14.
 */
public interface HomeworkService {
    Integer uploadHomerWork(AddHomerworkRequest addHomerworkRequest);

    HomeworkResponseList downloadHomerWork(DownloadHomeworkRequest downloadHomeworkRequest) throws Exception;

    Integer updateHomeWork(UpdateHomerworkRequest addHomerworkRequest);

    HomeworkResponseList selectAllHomework(DownloadHomeworkRequest selectRequest);

    HomeworkResponseList selectAllHomeworkByUserId(SelectUserHomeworkRequest selectRequest);

    HomeworkResponseList getHomeworkByClassId(Long userId,Long classId,Short mark, Integer pageNumber, Integer pageSize);

}
