package com.jad.aop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jad.aop.mapper.LogMapper;
import com.jad.aop.po.Log;
import com.jad.aop.service.ILogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Service
public class LogServiceImpl implements ILogService {

    @Resource
    private LogMapper logMapper;

    @Override
    public PageInfo findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<HashMap<String,String>> list = logMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void save(Log log) {
        logMapper.save(log);
    }
}
