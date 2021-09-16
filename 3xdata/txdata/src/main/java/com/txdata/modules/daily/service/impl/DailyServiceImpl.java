package com.txdata.modules.daily.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.modules.daily.dao.DailyArrangeDao;
import com.txdata.modules.daily.dao.DailyTaskDao;
import com.txdata.modules.daily.entity.Daily;
import com.txdata.modules.daily.dao.DailyDao;
import com.txdata.modules.daily.entity.DailyArrange;
import com.txdata.modules.daily.entity.DailyTask;
import com.txdata.modules.daily.service.DailyService;
import com.txdata.modules.project.domain.ProjectDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 工作日报信息表(TDaily)表服务实现类
 *
 * @author makejava
 * @since 2021-07-22 13:26:43
 */
@Service
public class DailyServiceImpl implements DailyService {
    @Autowired
    private DailyDao dailyDao;
    @Autowired
    private DailyTaskDao dailyTaskDao;
    @Autowired
    private DailyArrangeDao dailyArrangeDao;



    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Daily queryById(String id) {
        return this.dailyDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Daily> queryAllByLimit(int offset, int limit) {
        return this.dailyDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param daily 实例对象
     * @return 实例对象
     */
    @Override
    public Daily insert(Daily daily) {
        return this.dailyDao.insert(daily);
    }

    /**
     * 修改数据
     *
     * @param id
     * @param status
     * @return 实例对象
     */
    @Override
    @Transactional(readOnly=false)
    public int updateStatus(@Param("id") String id, @Param("status") String status) {
        Daily daily = new Daily();
        daily.setId(id);
        daily.setStatus(status);
        return dailyDao.update(daily);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String id) {
        return this.dailyDao.deleteById(id);
    }

    @Override
    public DailyTask QueryByTask(String id) {
        return dailyDao.QueryByTask(id);
    }

    @Override
    public List<DailyTask> queryByProject(String projectId,String writeUser) {
        return dailyDao.queryByProject(projectId,writeUser);
    }

    @Override
    public List<Daily> list(Map<String, Object> map) {
        return dailyDao.list(map);
    }

    @Override
    public Page<Daily> list(Page<Daily> page, Map<String, Object> map) {
        Page<Daily> dailyPage = dailyDao.list(page, map);
        List<Daily> projectList = dailyPage.getRecords();
        return dailyPage;
    }

    @Override
    public List<Daily> list() {
        return dailyDao.list();
    }
}
