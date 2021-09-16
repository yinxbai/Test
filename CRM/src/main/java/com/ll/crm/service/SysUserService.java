package com.ll.crm.service;

import com.ll.crm.entity.SysUser;

import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2021-06-30 09:53:06
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    void insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    void update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(String id);

    /**
     * 登录
     * @param sysUser 用户
     * @return 成功登录
     */
    SysUser login(SysUser sysUser);

    /**
     * Id修改密码
     * @param sysUser 主键
     * @return 对象
     */
    void changePassword(SysUser sysUser);

    List<SysUser> findAll();

    void deleteAll(String ids);

    List<SysUser> queryByName(String name);
}
