package com.txdata.modules.daily.service;

import com.txdata.modules.daily.entity.Tasktype;

import java.util.List;

/**
 * 职位表(Tasktype)表服务接口
 *
 * @author makejava
 * @since 2021-07-23 09:24:05
 */
public interface TasktypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Tasktype queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Tasktype> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param Tasktype 实例对象
     * @return 实例对象
     */
    Tasktype insert(Tasktype Tasktype);

    /**
     * 修改数据
     *
     * @param Tasktype 实例对象
     * @return 实例对象
     */
    Tasktype update(Tasktype Tasktype);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    /**
     * 获取全部任务类型
     * @return
     */
    List<Tasktype> getList();

    /**
     * 获取任务类型详情
     * @param id
     * @return
     */
    Tasktype queryByTaskOrArrange(String id);

}
