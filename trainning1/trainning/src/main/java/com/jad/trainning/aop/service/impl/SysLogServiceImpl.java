package com.jad.trainning.aop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jad.trainning.aop.mapper.SysLogMapper;
import com.jad.trainning.aop.po.SysLog;
import com.jad.trainning.aop.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public PageInfo findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String,Object>> list = sysLogMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void save(SysLog sysLog) {
        sysLogMapper.save(sysLog);
    }


}
