package com.txdata.modules.daily.service;

import com.txdata.common.persistence.CrudService;
import com.txdata.modules.daily.entity.DailyTask;

import java.util.List;

/**
 * 工作日报任务明细表(TDailyTask)表服务接口
 *
 * @author makejava
 * @since 2021-07-22 13:26:50
 */
public interface DailyTaskService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DailyTask queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DailyTask> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dailyTask 实例对象
     * @return 实例对象
     */
    DailyTask insert(DailyTask dailyTask);

    /**
     * 修改数据
     *
     * @param dailyTask 实例对象
     * @return 实例对象
     */
    DailyTask update(DailyTask dailyTask);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
