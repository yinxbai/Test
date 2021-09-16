package com.yq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yq.mapper.CourseResourceMapper;
import com.yq.po.CourseResource;
import com.yq.po.Exercise;
import com.yq.po.Student;
import com.yq.po.Teacher;
import com.yq.service.ICourseResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CourseResourceServiceImpl implements ICourseResourceService {

    @Resource
    private CourseResourceMapper courseResourceMapper;


    @Override
    public PageInfo queryByPage(Integer pageNum, Integer pageSize,String teacherId) {
        PageHelper.startPage(pageNum,pageSize);
        List<CourseResource> list = courseResourceMapper.findAllByTeacher(teacherId);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void save(CourseResource courseResource) {
        courseResourceMapper.save(courseResource);
    }

    @Override
    public CourseResource findById(String id) {
        return courseResourceMapper.findById(id);
    }

    @Override
    public List<CourseResource> findAllByStudent(Teacher teacher) {
        return courseResourceMapper.findAllByStudent(teacher);
    }

    @Override
    public List<CourseResource> findByStudent(Student student) {

        return courseResourceMapper.findByStudent(student);
    }

}
