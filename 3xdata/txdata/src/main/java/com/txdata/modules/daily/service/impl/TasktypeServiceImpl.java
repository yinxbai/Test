package com.txdata.modules.daily.service.impl;

import com.txdata.modules.daily.dao.TasktypeDao;
import com.txdata.modules.daily.entity.Tasktype;
import com.txdata.modules.daily.service.TasktypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 职位表(TTasktype)表服务实现类
 *
 * @author makejava
 * @since 2021-07-23 09:24:05
 */
@Service
public class TasktypeServiceImpl implements TasktypeService {

    @Autowired
    private TasktypeDao tasktypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Tasktype queryById(String id) {
        return this.tasktypeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Tasktype> queryAllByLimit(int offset, int limit) {
        return this.tasktypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tTasktype 实例对象
     * @return 实例对象
     */
    @Override
    public Tasktype insert(Tasktype tTasktype) {
        this.tasktypeDao.insert(tTasktype);
        return tTasktype;
    }

    /**
     * 修改数据
     *
     * @param tTasktype 实例对象
     * @return 实例对象
     */
    @Override
    public Tasktype update(Tasktype tTasktype) {
        this.tasktypeDao.update(tTasktype);
        return this.queryById(tTasktype.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.tasktypeDao.deleteById(id) > 0;
    }

    @Override
    public List<Tasktype> getList() {
        return tasktypeDao.getList();
    }

    /**
     * 获取任务类型详情
     * @param id
     * @return
     */
    @Override
    public Tasktype queryByTaskOrArrange(String id) {
        return tasktypeDao.queryByTaskOrArrange(id);
    }
}
