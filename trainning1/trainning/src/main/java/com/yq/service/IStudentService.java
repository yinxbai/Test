package com.yq.service;

import com.github.pagehelper.PageInfo;
import com.yq.po.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {

    public Student findStudentByAccountAndPassword(Student student);

    public void changePassword(Student student);

    public List<Student> findAll();

    public void deleteById(String id);

    public void update(Student student);

    public void save(Student student);

    public int findCount(String clazzId);

    public void bacthDelete(String ids[]);

    PageInfo info(int pageNum, int pageSize);
}
