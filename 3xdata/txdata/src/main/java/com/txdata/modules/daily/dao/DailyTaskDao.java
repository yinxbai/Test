package com.txdata.modules.daily.dao;

import com.txdata.modules.daily.entity.DailyTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 工作日报任务明细表(TDailyTask)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-22 13:26:50
 */
@Mapper
public interface DailyTaskDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DailyTask queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DailyTask> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dailyTask 实例对象
     * @return 对象列表
     */
    List<DailyTask> queryAll(DailyTask dailyTask);

    /**
     * 新增数据
     *
     * @param dailyTask 实例对象
     * @return 影响行数
     */
    int insert(DailyTask dailyTask);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TDailyTask> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DailyTask> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TDailyTask> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DailyTask> entities);

    /**
     * 修改数据
     *
     * @param dailyTask 实例对象
     * @return 影响行数
     */
    int update(DailyTask dailyTask);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

