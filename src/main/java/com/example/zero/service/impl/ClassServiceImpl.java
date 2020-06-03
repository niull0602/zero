package com.example.zero.service.impl;

import com.example.zero.dao.ClassDao;
import com.example.zero.pojo.Class;
import com.example.zero.request.ClassRequest;
import com.example.zero.response.ClassResponse;
import com.example.zero.service.ClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-31 14:59.
 */
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassDao classDao;

    @Override
    public Integer add(ClassRequest classRequest) {
        Class aClass = new Class();
        BeanUtils.copyProperties(classRequest,aClass);
        return classDao.insert(aClass);
    }

    @Override
    public ClassResponse getAll(Integer pageNumber, Integer pageSize) {
        ClassResponse classResponse = new ClassResponse();
        PageHelper.startPage(pageNumber,pageSize);
        List<Class> classList =  classDao.getAll();
        PageInfo<Class> pageInfo = new PageInfo<>(classList);
        classResponse.setList(pageInfo.getList());
        classResponse.setTotal(pageInfo.getTotal());
        return classResponse;
    }
}
