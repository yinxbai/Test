package com.ll.crm.dao;

import com.ll.crm.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Customer)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-30 09:51:48
 */
@Mapper
public interface CustomerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Customer queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Customer> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param customer 实例对象
     * @return 对象列表
     */
    List<Customer> queryAll(Customer customer);

    /**
     * 新增数据
     *
     * @param customer 实例对象
     * @return 影响行数
     */
    void insert(Customer customer);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Customer> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Customer> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Customer> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Customer> entities);

    /**
     * 修改数据
     *
     * @param customer 实例对象
     * @return 影响行数
     */
    int update(Customer customer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    void deleteById(String id);

    void deleteAll(String ids);

    /**
     * 查询全部客户
     * @return
     */
    List<Customer> findAll();

    /**
     * 查询
     * @param name
     * @return
     */
    List<Customer> queryName(String name);


}

