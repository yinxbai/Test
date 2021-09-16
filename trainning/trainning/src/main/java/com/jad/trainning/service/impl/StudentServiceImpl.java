package com.jad.trainning.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jad.trainning.mapper.StudentMapper;
import com.jad.trainning.po.CourseResource;
import com.jad.trainning.po.Student;
import com.jad.trainning.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findStudentByAccountAndPassword(Student student) {
        return studentMapper.findStudentByAccountAndPassword(student);
    }

    @Override
    public void changePassword(Student student) {
        studentMapper.changePassword(student);
    }

    @Override
    public PageInfo findCourseResourceByStudent(Integer pageNum, Integer pageSize,String studentId) {
        PageHelper.startPage(pageNum,pageSize);
        List<CourseResource> list = studentMapper.findCourseResourceByStudent(studentId);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public PageInfo findStudentByTeaacher(Integer pageNum, Integer pageSize, String teacherId) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list = studentMapper.findStudentByTeaacher(teacherId);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void save(Student student) {
        studentMapper.save(student);
    }

    @Override
    public PageInfo findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list = studentMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void delete(String id) {
        studentMapper.delete(id);
    }

    @Override
    public Student findById(String id) {
        Student student =  studentMapper.findById(id);
        return student;
    }

    @Override
    @Transactional
    public void deleteAll(String ids) {
        String[] array = ids.split(",");
        for (String id : array){
            delete(id);
        }
    }

    @Override
    public PageInfo findExerciseCoruseResourceByStudent(Integer pageNum, Integer pageSize,String studentId) {
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String,Object>> list = studentMapper.findExerciseCoruseResourceByStudent(studentId);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
