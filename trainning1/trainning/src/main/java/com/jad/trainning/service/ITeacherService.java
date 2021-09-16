package com.jad.trainning.service;

import com.github.pagehelper.PageInfo;
import com.jad.trainning.po.Teacher;

import java.util.List;

public interface ITeacherService {
    public Teacher findTeacherByAccountAndPassword(Teacher teacher);
    public void changePassword(Teacher teacher);
    public List<Teacher> findAll();
    public PageInfo queryByPage(int pageNum, int pageSize);
    public void delete(String id);
    public void deleteAll(String ids) throws Exception;
    public void save(Teacher teacher);
    public void update(Teacher teacher);
    public Teacher findById(String id);
}
