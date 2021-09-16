package com.ll.crm.dao;

import com.ll.crm.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (City)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-30 09:50:54
 */
@Mapper
public interface CityDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    City queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<City> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     * @return 对象列表
     */
    List<City> queryAll();

    /**
     * 新增数据
     *
     * @param city 实例对象
     * @return 影响行数
     */
    int insert(City city);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     * @param entities List<City> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<City> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<City> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<City> entities);

    /**
     * 修改数据
     *
     * @param city 实例对象
     * @return 影响行数
     */
    int update(City city);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    void deleteById(String id);

    void deleteAll(String ids);

}

