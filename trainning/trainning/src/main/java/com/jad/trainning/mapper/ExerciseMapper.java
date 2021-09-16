package com.jad.trainning.mapper;

import com.jad.trainning.po.Exercise;
import com.jad.trainning.po.Student;

import java.util.List;
import java.util.Map;

public interface ExerciseMapper {
    public List<Map<String,Object>> findByStudent(Student student);
    public void save(Exercise exercise);
}
