package com.jad.trainning.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jad.trainning.mapper.CourseResourceMapper;
import com.jad.trainning.po.CourseResource;
import com.jad.trainning.service.ICourseResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseResourceServiceImpl implements ICourseResourceService {
    @Autowired
    private CourseResourceMapper courseResourceMapper;

    @Override
    public PageInfo queryByPage(Integer pageNum, Integer pageSize, String teacherId) {
        PageHelper.startPage(pageNum,pageSize);
        List<CourseResource> list = courseResourceMapper.findAllByTeacher(teacherId);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void save(CourseResource courseResource) {
        courseResourceMapper.save(courseResource);
    }
}
