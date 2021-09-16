package com.txdata.modules.daily.service.impl;

import com.txdata.modules.daily.entity.Project;
import com.txdata.modules.daily.dao.ProjectDao;
import com.txdata.modules.daily.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 项目备案基本信息表(TProject)表服务实现类
 *
 * @author makejava
 * @since 2021-07-23 09:43:59
 */
@Service("tProjectService")
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectDao projectDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Project queryById(String id) {
        return this.projectDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Project> queryAllByLimit(int offset, int limit) {
        return this.projectDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param project 实例对象
     * @return 实例对象
     */
    @Override
    public Project insert(Project project) {
        this.projectDao.insert(project);
        return project;
    }

    /**
     * 修改数据
     *
     * @param project 实例对象
     * @return 实例对象
     */
    @Override
    public Project update(Project project) {
        this.projectDao.update(project);
        return this.queryById(project.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.projectDao.deleteById(id) > 0;
    }

    @Override
    public List<Project> getList() {
        return projectDao.getList();
    }

    @Override
    public Project queryByTask(String id) {
        return projectDao.queryByTask(id);
    }
}
