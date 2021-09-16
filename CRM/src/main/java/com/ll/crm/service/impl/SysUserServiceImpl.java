package com.ll.crm.service.impl;

import com.ll.crm.entity.SysUser;
import com.ll.crm.dao.SysUserDao;
import com.ll.crm.service.SysUserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2021-06-30 09:53:06
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(String id) {
        return this.sysUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return this.sysUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(SysUser sysUser) {
        sysUserDao.insert(sysUser);
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public void update(SysUser sysUser) {
        sysUserDao.update(sysUser);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(String id) {

        sysUserDao.deleteById(id);
    }

    /**
     * 登录操作
     * @param sysUser 用户
     * @return
     */
    @Override
    public SysUser login(SysUser sysUser) {

        return sysUserDao.login(sysUser);
    }

    /**
     * 修改密码
     * @param sysUser 主键
     */
    @Override
    public void changePassword(SysUser sysUser) {

        sysUserDao.changePassword(sysUser);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserDao.findAll();
    }

    @Override
    public void deleteAll(String ids) {
        String[] _ids = ids.split(",");
        for(String id : _ids){
            deleteById(id);
        }
    }

    @Override
    public List<SysUser> queryByName(String name) {
        return sysUserDao.queryByName(name);
    }
}
