package com.yq.aop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yq.aop.mapper.SysLogMapper;
import com.yq.aop.po.SysLog;
import com.yq.aop.service.ISysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author InRoota
 * @date 2021-06-15  19:09
 */
@Service
public class SysLogServiceImpl implements ISysLogService {

    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public PageInfo findAll(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Map<String, Object>> list = sysLogMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void save(SysLog sysLog) {
        sysLogMapper.save(sysLog);
    }
}
