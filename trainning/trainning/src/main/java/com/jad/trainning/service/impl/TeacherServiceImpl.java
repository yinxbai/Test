package com.jad.trainning.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jad.trainning.mapper.TeacherMapper;
import com.jad.trainning.po.Teacher;
import com.jad.trainning.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
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
    public List<Teacher> findAll(){
        return teacherMapper.findAll();
    }

    @Override
    public PageInfo queryByPage(int pageNum, int pageSize) {
        //1、指定当前第几页，以及每页显示的记录数
        PageHelper.startPage(pageNum,pageSize);
        //2、查询结果
        List<Teacher> list = teacherMapper.findAll();

        PageInfo pageInfo = new PageInfo(list);

        return pageInfo;
    }

    @Override
    public void delete(String id){
        teacherMapper.delete(id);
    }

    @Override
    @Transactional
    public void deleteAll(String ids) throws Exception {
        String[] _ids = ids.split(",");
        for(String id : _ids){
            delete(id);
        }
    }

    @Override
    public void save(Teacher teacher) {
        teacherMapper.save(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherMapper.update(teacher);
    }

    @Override
    public Teacher findById(String id) {
        return teacherMapper.findById(id);
    }
}
