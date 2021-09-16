package com.yq.mapper;

import com.yq.po.CourseResource;
import com.yq.po.Exercise;
import com.yq.po.Student;
import com.yq.po.Teacher;

import java.util.List;

public interface CourseResourceMapper {

    List<CourseResource> findAllByTeacher(String teacherId);

    void save(CourseResource courseResource);

    CourseResource findById(String id);

    List<CourseResource> findAllByStudent(Teacher teacher);

    List<CourseResource> findByStudent(Student student);

}
