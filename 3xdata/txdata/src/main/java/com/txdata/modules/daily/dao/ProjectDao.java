package com.txdata.modules.daily.dao;

import com.txdata.modules.daily.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目备案基本信息表(TProject)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-23 09:43:59
 */

@Mapper()
public interface ProjectDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Project queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Project> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param project 实例对象
     * @return 对象列表
     */
    List<Project> queryAll(Project project);

    /**
     * 新增数据
     *
     * @param project 实例对象
     * @return 影响行数
     */
    int insert(Project project);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TProject> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Project> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TProject> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Project> entities);

    /**
     * 修改数据
     *
     * @param project 实例对象
     * @return 影响行数
     */
    int update(Project project);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 获取项目名称
     * @return
     */
    List<Project> getList();

    /**
     * projectId匹配项目名
     * @param id
     * @return
     */
    Project queryByTask(String id);

}

