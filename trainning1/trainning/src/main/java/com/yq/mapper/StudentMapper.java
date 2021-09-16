package com.yq.mapper;

import com.yq.po.Student;

import java.util.List;

public interface StudentMapper {

    public Student findStudentByAccountAndPassword(Student student);

    public void changePassword(Student student);

    public List<Student> findAll();

    public void deleteById(String id);

    public void update(Student student);

    public void save(Student student);

    public int findCount(String clazzId);

    public List<Student> info(int pageSize,int pageNum);


}
