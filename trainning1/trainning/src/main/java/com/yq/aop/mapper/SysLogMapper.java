package com.yq.aop.mapper;

import com.yq.aop.po.SysLog;

import java.util.List;
import java.util.Map;

/**
 * @author InRoota
 * @date 2021-06-15  18:53
 */
public interface SysLogMapper {

    List<Map<String,Object>> findAll();

    void save(SysLog sysLog);
}
