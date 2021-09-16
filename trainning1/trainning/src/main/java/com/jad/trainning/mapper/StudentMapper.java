package com.jad.trainning.mapper;

import com.jad.trainning.po.CourseResource;
import com.jad.trainning.po.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    public Student findStudentByAccountAndPassword(Student student);
    public void changePassword(Student student);
    public List<CourseResource> findCourseResourceByStudent(String studentId);
    public List<Student> findStudentByTeaacher(String teacherId);
    public void save(Student student);
    public List<Student> findAll();
    public void update(Student student);
    public void delete(String id);
    public Student findById(String id);
    public List<Map<String,Object>> findExerciseCoruseResourceByStudent(String studentId);
}
