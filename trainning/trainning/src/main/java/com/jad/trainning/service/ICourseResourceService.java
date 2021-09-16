package com.jad.trainning.service;

import com.github.pagehelper.PageInfo;
import com.jad.trainning.po.CourseResource;

public interface ICourseResourceService {
    public PageInfo queryByPage(Integer pageNum, Integer pageSize, String teacherId);
    public void save(CourseResource courseResource);
}
