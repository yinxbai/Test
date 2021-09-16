package com.yq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yq.mapper.StudentMapper;
import com.yq.po.CourseResource;
import com.yq.po.Student;
import com.yq.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
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
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public void deleteById(String id) {
        studentMapper.deleteById(id);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void save(Student student) {
        studentMapper.save(student);
    }

    @Override
    public int findCount(String clazzId) {
        return studentMapper.findCount(clazzId);
    }

    @Override
    public void bacthDelete(String[] ids) {
        for (String s : ids) {
            studentMapper.deleteById(s);
        }
    }

    @Override
    public PageInfo info(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Student> list = studentMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);

        return pageInfo;
    }
}
