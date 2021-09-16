package com.jad.trainning.service;

import com.github.pagehelper.PageInfo;
import com.jad.trainning.po.Exercise;
import com.jad.trainning.po.Student;

public interface IExerciseService {
    public PageInfo findByStudent(Integer pageNum, Integer pageSize, Student student);
    public void save(Exercise exercise);
}
