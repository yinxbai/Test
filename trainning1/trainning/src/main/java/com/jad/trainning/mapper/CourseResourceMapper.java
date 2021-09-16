package com.jad.trainning.mapper;

import com.jad.trainning.po.CourseResource;

import java.util.List;

public interface CourseResourceMapper {
    public List<CourseResource> findAllByTeacher(String teacherId);
    public void save(CourseResource courseResource);
    public List<CourseResource> findAllByStudent(String studentId);
}
