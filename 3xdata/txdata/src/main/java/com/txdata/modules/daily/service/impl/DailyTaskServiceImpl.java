package com.txdata.modules.daily.service.impl;

import com.txdata.modules.daily.dao.DailyTaskDao;
import com.txdata.modules.daily.entity.DailyTask;
import com.txdata.modules.daily.service.DailyTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工作日报任务明细表(TDailyTask)表服务实现类
 *
 * @author makejava
 * @since 2021-07-22 13:26:50
 */
@Service
public class DailyTaskServiceImpl implements DailyTaskService {
    @Resource
    private DailyTaskDao dailyTaskDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DailyTask queryById(String id) {
        return this.dailyTaskDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<DailyTask> queryAllByLimit(int offset, int limit) {
        return this.dailyTaskDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dailyTask 实例对象
     * @return 实例对象
     */
    @Override
    public DailyTask insert(DailyTask dailyTask) {
        this.dailyTaskDao.insert(dailyTask);
        return dailyTask;
    }

    /**
     * 修改数据
     *
     * @param dailyTask 实例对象
     * @return 实例对象
     */
    @Override
    public DailyTask update(DailyTask dailyTask) {
        this.dailyTaskDao.update(dailyTask);
        return this.queryById(dailyTask.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.dailyTaskDao.deleteById(id) > 0;
    }
}
