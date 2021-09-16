package com.jad.trainning.aop.service;

import com.github.pagehelper.PageInfo;
import com.jad.trainning.aop.po.SysLog;

import java.io.IOException;

public interface ISysLogService {

    public PageInfo findAll(Integer pageNum, Integer pageSize);
    public void save(SysLog sysLog);

}
