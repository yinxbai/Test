package com.jad.service;

import com.github.pagehelper.PageInfo;
import com.jad.po.SysUser;

public interface ISysUserService {
    public SysUser findSysUserByAccountAndPassword(SysUser sysUser);
    public void changePassword(SysUser sysUser);
    public SysUser findSysUserByID(String id);
    public PageInfo findAll(Integer pageNum, Integer pageSize);
    public void save(SysUser user);
    public void delete(String id);
    public void update(SysUser user);
    public void batchDelete(String[] ids);
    public SysUser findSysUserByAccount(String account);

}
