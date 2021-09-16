package com.jad.trainning.mapper;

import com.jad.trainning.po.Teacher;

import java.util.List;

public interface TeacherMapper {

    public Teacher findTeacherByAccountAndPassword(Teacher teacher);
    public void changePassword(Teacher teacher);
    public List<Teacher> findAll();
    public void save(Teacher teacher);
    public void delete(String id);
    public void update(Teacher teacher);
    public Teacher findById(String id);

}
