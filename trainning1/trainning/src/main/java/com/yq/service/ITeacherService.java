package com.yq.service;

import com.github.pagehelper.PageInfo;
import com.yq.po.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITeacherService {
    public Teacher findTeacherByAccountAndPassword(Teacher teacher);

    public void changePassword(Teacher teacher);

    public List<Teacher> findAll();

    public void deleteById(String id);

    public void update(Teacher teacher);

    public void save(Teacher teacher);

    public int findCount(String clazzId);

    public void bacthDelete(String ids[]);

    public PageInfo queryByPage(int pageNum,int pageSize);
}
