package com.yq.mapper;

import com.yq.po.Exercise;
import com.yq.po.Student;

import java.util.List;

/**
 * @author InRoota
 * @date 2021-06-21  17:14
 */
public interface ExerciseMapper {

    List<Exercise> findAll();

    List<Exercise> info(int pageSize, int pageNum);
}
