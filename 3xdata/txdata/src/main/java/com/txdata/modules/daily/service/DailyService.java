package com.txdata.modules.daily.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.modules.daily.dao.DailyDao;
import com.txdata.modules.daily.entity.Daily;
import com.txdata.modules.daily.entity.DailyTask;
import com.txdata.modules.project.domain.ProjectDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 工作日报信息表(TDaily)表服务接口
 *
 * @author makejava
 * @since 2021-07-22 13:26:42
 */
public interface DailyService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Daily queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Daily> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param daily 实例对象
     * @return 实例对象
     */
    Daily insert(Daily daily);

    /**
     * 修改数据
     *
     * @param id
     * @param status
     * @return 实例对象
     */
    int updateStatus(String id, String status);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(String id);

    /**
     * 通过任务Id查询任务详情
     * @param id
     * @return
     */
    DailyTask QueryByTask(String id);

    /**
     * 根据项目查看日报任务明细列表
     * @param projectId
     * @param writeUser
     * @return
     */
    List<DailyTask> queryByProject(String projectId,String writeUser);

    /**
     * 项目日报列表
     * @param page
     * @param map
     * @return
     */
    Page<Daily> list(Page<Daily> page, @Param("entity") Map<String,Object> map);

    /**
     * 项目日报列表
     * @param map
     * @return
     */
    List<Daily> list(@Param("entity") Map<String,Object> map);

    /**
     * 项目日报列表
     * @return
     */
    List<Daily> list();

}
