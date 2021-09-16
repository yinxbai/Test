package com.yq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yq.mapper.TeacherMapper;
import com.yq.po.Teacher;
import com.yq.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Resource
    private TeacherMapper teacherMapper;
    @Override
    public Teacher findTeacherByAccountAndPassword(Teacher teacher) {
        return teacherMapper.findTeacherByAccountAndPassword(teacher);
    }

    @Override
    public void changePassword(Teacher teacher) {
        teacherMapper.changePassword(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.findAll();
    }

    @Override
    public void deleteById(String id) {
        teacherMapper.deleteById(id);
    }

    @Override
    public void update(Teacher teacher) {
        teacherMapper.update(teacher);
    }

    @Override
    public void save(Teacher teacher) {
        teacherMapper.save(teacher);
    }

    @Override
    public int findCount(String clazzId) {
        return teacherMapper.findCount(clazzId);
    }

    @Override
//    @Transactional
    public void bacthDelete(String[] ids) {
        for (String s : ids) {
            teacherMapper.deleteById(s);
        }
    }

    @Override
    public PageInfo queryByPage(int pageNum,int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Teacher> list = teacherMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
