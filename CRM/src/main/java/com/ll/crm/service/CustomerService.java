package com.ll.crm.service;

import com.github.pagehelper.PageInfo;
import com.ll.crm.entity.Customer;

import java.util.List;

/**
 * (Customer)表服务接口
 *
 * @author makejava
 * @since 2021-06-30 09:52:54
 */
public interface CustomerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Customer queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Customer> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param customer 实例对象
     * @return 实例对象
     */
    void insert(Customer customer);

    /**
     * 修改数据
     *
     * @param customer 实例对象
     * @return 实例对象
     */
    Customer update(Customer customer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(String id);

    void deleteAll(String ids);

    /**
     * 全部查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo findAll(Integer pageNum,Integer pageSize);

    /**
     * 简单查询
     * @return
     */
    List<Customer> list();
}
