package com.jad.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jad.mapper.SysUserMapper;
import com.jad.po.Customer;
import com.jad.po.SysUser;
import com.jad.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements ISysUserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser findSysUserByAccountAndPassword(SysUser sysUser) {
        return sysUserMapper.findSysUserByAccountAndPassword(sysUser);
    }

    @Override
    public void changePassword(SysUser sysUser) {
        sysUserMapper.changePassword(sysUser);
    }

    @Override
    public SysUser findSysUserByID(String id) {
        return sysUserMapper.findSysUserByID(id);
    }

    @Override
    public PageInfo findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysUser> list = sysUserMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void save(SysUser sysUser) {
        sysUserMapper.save(sysUser);
    }

    @Override
    public void delete(String id) {
        sysUserMapper.delete(id);
    }

    @Override
    public void update(SysUser user) {
        sysUserMapper.update(user);
    }

    @Override
    public void batchDelete(String[] ids) {
        for (String s : ids) {
            sysUserMapper.delete(s);
        }
    }

    @Override
    public SysUser findSysUserByAccount(String account) {
        return sysUserMapper.findSysUserByAccount(account);
    }
}
