package com.jad.trainning.service;

import com.github.pagehelper.PageInfo;
import com.jad.trainning.mapper.StudentMapper;
import com.jad.trainning.po.CourseResource;
import com.jad.trainning.po.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    public Student findStudentByAccountAndPassword(Student student);
    public void changePassword(Student student);
    public PageInfo findCourseResourceByStudent(Integer pageNum, Integer pageSize,String studentId);
    public PageInfo findStudentByTeaacher(Integer pageNum, Integer pageSize,String teacherId);
    public void save(Student student);
    public PageInfo findAll(Integer pageNum,Integer pageSize);
    public void update(Student student);
    public void delete(String id);
    public Student findById(String id);
    public void deleteAll(String ids);
    public PageInfo findExerciseCoruseResourceByStudent(Integer pageNum,Integer pageSize,String studentId);
}
