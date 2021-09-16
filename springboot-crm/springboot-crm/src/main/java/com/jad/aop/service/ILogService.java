package com.jad.aop.service;

import com.github.pagehelper.PageInfo;
import com.jad.aop.po.Log;

import java.util.HashMap;
import java.util.List;

public interface ILogService {

    public PageInfo findAll(Integer pageNum, Integer pageSize);

    public void save(Log log);
}
