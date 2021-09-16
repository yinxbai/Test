package com.ll.crm.dao;

import com.ll.crm.entity.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

/**
 * (Log)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-30 09:52:11
 */
@Mapper
public interface LogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Log queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Log> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Log> queryAll();

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 影响行数
     */
    void insert(Log log);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Log> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Log> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Log> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Log> entities);

    /**
     * 修改数据
     *
     * @param log 实例对象
     * @return 影响行数
     */
    int update(Log log);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    void exportExcel() throws IOException;

}

