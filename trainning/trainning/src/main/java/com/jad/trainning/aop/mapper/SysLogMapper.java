package com.jad.trainning.aop.mapper;

import com.jad.trainning.aop.po.SysLog;

import java.util.List;
import java.util.Map;

public interface SysLogMapper {
    public List<Map<String,Object>> findAll();
    public void save(SysLog sysLog);
    public List<SysLog> queryList();
}
