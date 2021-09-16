package com.jad.mapper;

import com.jad.po.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {
    public SysUser findSysUserByAccountAndPassword(SysUser sysUser);
    public void changePassword(SysUser sysUser);
    public SysUser findSysUserByID(String id);
    public List<SysUser> findAll();
    public void save(SysUser user);
    public void delete(String id);
    public void update(SysUser user);
    public SysUser findSysUserByAccount(String account);
}
