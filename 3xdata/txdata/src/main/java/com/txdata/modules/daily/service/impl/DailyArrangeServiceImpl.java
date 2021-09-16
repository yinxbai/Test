package com.txdata.modules.daily.service.impl;

import com.txdata.modules.daily.dao.DailyArrangeDao;
import com.txdata.modules.daily.entity.DailyArrange;
import com.txdata.modules.daily.service.DailyArrangeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日报下一步安排表(TDailyArrange)表服务实现类
 *
 * @author makejava
 * @since 2021-07-22 13:26:47
 */
@Service
public class DailyArrangeServiceImpl implements DailyArrangeService {
    @Resource
    private DailyArrangeDao dailyArrangeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DailyArrange queryById(String id) {
        return this.dailyArrangeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<DailyArrange> queryAllByLimit(int offset, int limit) {
        return this.dailyArrangeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tDailyArrange 实例对象
     * @return 实例对象
     */
    @Override
    public DailyArrange insert(DailyArrange tDailyArrange) {
        this.dailyArrangeDao.insert(tDailyArrange);
        return tDailyArrange;
    }

    /**
     * 修改数据
     *
     * @param tDailyArrange 实例对象
     * @return 实例对象
     */
    @Override
    public DailyArrange update(DailyArrange tDailyArrange) {
        this.dailyArrangeDao.update(tDailyArrange);
        return this.queryById(tDailyArrange.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.dailyArrangeDao.deleteById(id) > 0;
    }
}
