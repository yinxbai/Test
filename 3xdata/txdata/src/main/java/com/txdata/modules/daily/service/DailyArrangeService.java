package com.txdata.modules.daily.service;

import com.txdata.modules.daily.entity.DailyArrange;

import java.util.List;

/**
 * 日报下一步安排表(TDailyArrange)表服务接口
 *
 * @author makejava
 * @since 2021-07-22 13:26:47
 */
public interface DailyArrangeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DailyArrange queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DailyArrange> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tDailyArrange 实例对象
     * @return 实例对象
     */
    DailyArrange insert(DailyArrange tDailyArrange);

    /**
     * 修改数据
     *
     * @param tDailyArrange 实例对象
     * @return 实例对象
     */
    DailyArrange update(DailyArrange tDailyArrange);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
