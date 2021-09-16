package com.jad.trainning.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jad.trainning.mapper.ExerciseMapper;
import com.jad.trainning.po.Exercise;
import com.jad.trainning.po.Student;
import com.jad.trainning.service.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExerciseServiceImpl implements IExerciseService {
    @Autowired
    private ExerciseMapper exerciseMapper;

    @Override
    public PageInfo findByStudent(Integer pageNum, Integer pageSize, Student student) {
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String,Object>> list = exerciseMapper.findByStudent(student);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void save(Exercise exercise) {
        exerciseMapper.save(exercise);
    }
}
