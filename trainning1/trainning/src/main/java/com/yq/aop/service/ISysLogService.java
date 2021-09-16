package com.yq.aop.service;

import com.github.pagehelper.PageInfo;
import com.yq.aop.po.SysLog;

/**
 * @author InRoota
 * @date 2021-06-15  19:08
 */
public interface ISysLogService {

    PageInfo findAll(Integer pageNum,Integer pageSize);
    void save(SysLog sysLog);
}
