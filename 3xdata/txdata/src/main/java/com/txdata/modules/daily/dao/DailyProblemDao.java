package com.txdata.modules.daily.dao;

import com.txdata.modules.daily.entity.DailyProblem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TDailyProblem)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-22 13:26:49
 */
@Mapper
public interface DailyProblemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DailyProblem queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DailyProblem> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dailyProblem 实例对象
     * @return 对象列表
     */
    List<DailyProblem> queryAll(DailyProblem dailyProblem);

    /**
     * 新增数据
     *
     * @param dailyProblem 实例对象
     * @return 影响行数
     */
    int insert(DailyProblem dailyProblem);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TDailyProblem> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DailyProblem> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TDailyProblem> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DailyProblem> entities);

    /**
     * 修改数据
     *
     * @param dailyProblem 实例对象
     * @return 影响行数
     */
    int update(DailyProblem dailyProblem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

