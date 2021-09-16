package com.yq.service;

import com.github.pagehelper.PageInfo;
import com.yq.po.CourseResource;
import com.yq.po.Exercise;
import com.yq.po.Student;
import com.yq.po.Teacher;

import java.util.List;

public interface ICourseResourceService {

    public PageInfo queryByPage(Integer pageNum,Integer pageSize,String teacherId);

    public void save(CourseResource courseResource);

    public CourseResource findById(String id);

    public List<CourseResource> findAllByStudent(Teacher teacher);

    List<CourseResource> findByStudent(Student student);


}
