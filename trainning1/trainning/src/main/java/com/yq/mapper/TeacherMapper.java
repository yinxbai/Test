package com.yq.mapper;

import com.yq.po.Teacher;

import java.util.List;

public interface TeacherMapper {

    public Teacher findTeacherByAccountAndPassword(Teacher teacher);

    public void changePassword(Teacher teacher);

    public List<Teacher> findAll();

    public void deleteById(String id);

    public void update(Teacher teacher);

    public void save(Teacher teacher);

    public int findCount(String clazzId);


}
