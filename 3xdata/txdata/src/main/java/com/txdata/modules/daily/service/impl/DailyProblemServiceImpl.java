package com.txdata.modules.daily.service.impl;

import com.txdata.modules.daily.dao.DailyProblemDao;
import com.txdata.modules.daily.entity.DailyProblem;
import com.txdata.modules.daily.service.DailyProblemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TDailyProblem)表服务实现类
 *
 * @author makejava
 * @since 2021-07-22 13:26:50
 */
@Service
public class DailyProblemServiceImpl implements DailyProblemService {
    @Resource
    private DailyProblemDao dailyProblemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DailyProblem queryById(String id) {
        return this.dailyProblemDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<DailyProblem> queryAllByLimit(int offset, int limit) {
        return this.dailyProblemDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tDailyProblem 实例对象
     * @return 实例对象
     */
    @Override
    public DailyProblem insert(DailyProblem tDailyProblem) {
        this.dailyProblemDao.insert(tDailyProblem);
        return tDailyProblem;
    }

    @Override
    public DailyProblem update(DailyProblem tDailyProblem) {
        return null;
    }


    /**
     * 修改数据
     *
     * @param tDailyProblem 实例对象
     * @return 实例对象
     */

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.dailyProblemDao.deleteById(id) > 0;
    }
}
