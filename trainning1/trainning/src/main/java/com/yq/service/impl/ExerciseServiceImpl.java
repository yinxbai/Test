package com.yq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yq.mapper.ExerciseMapper;
import com.yq.po.Exercise;
import com.yq.service.ExerciseService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author InRoota
 * @date 2021-06-21  17:26
 */
@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Resource
    private ExerciseMapper exerciseMapper;

    @Override
    public PageInfo findAll(int pagrSize,int pageNum) {

        PageHelper.startPage(pageNum,pagrSize);
        List<Exercise> list = exerciseMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
