package com.txdata.modules.daily.dao;

import com.txdata.modules.daily.entity.DailyArrange;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 日报下一步安排表(TDailyArrange)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-22 13:26:46
 */
@Mapper
public interface DailyArrangeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DailyArrange queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DailyArrange> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dailyArrange 实例对象
     * @return 对象列表
     */
    List<DailyArrange> queryAll(DailyArrange dailyArrange);

    /**
     * 新增数据
     *
     * @param dailyArrange 实例对象
     * @return 影响行数
     */
    int insert(DailyArrange dailyArrange);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TDailyArrange> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DailyArrange> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TDailyArrange> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DailyArrange> entities);

    /**
     * 修改数据
     *
     * @param dailyArrange 实例对象
     * @return 影响行数
     */
    int update(DailyArrange dailyArrange);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

