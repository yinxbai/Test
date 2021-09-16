package com.yq.service;

import com.github.pagehelper.PageInfo;
import com.yq.po.Exercise;

import java.util.List;

/**
 * @author InRoota
 * @date 2021-06-21  17:26
 */
public interface ExerciseService {

    PageInfo findAll(int pageSize, int pageNum);
}
