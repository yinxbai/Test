package com.txdata.modules.daily.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.txdata.modules.daily.entity.Daily;
import com.txdata.modules.daily.entity.DailyTask;
import com.txdata.modules.project.domain.ProjectDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 工作日报信息表(TDaily)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-22 13:26:41
 */
@Mapper
public interface DailyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Daily queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Daily> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param daily 实例对象
     * @return 对象列表
     */
    List<Daily> queryAll(Daily daily);

    /**
     * 新增数据
     *
     * @param daily 实例对象
     * @return 影响行数
     */
    Daily insert(Daily daily);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TDaily> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Daily> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TDaily> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Daily> entities);

    /**
     * 修改数据
     *
     * @param daily 实例对象
     * @return 影响行数
     */
    int update(Daily daily);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 查看任务详情
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
    List<DailyTask> queryByProject(@Param("projectId") String projectId,@Param("writeUser") String writeUser);

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

