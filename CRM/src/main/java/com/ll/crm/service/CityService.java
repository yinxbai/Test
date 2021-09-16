package com.ll.crm.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import com.ll.crm.entity.City;

import java.util.List;

/**
 * (City)表服务接口
 *
 * @author makejava
 * @since 2021-06-30 09:52:39
 */
public interface CityService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    City queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<City> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param city 实例对象
     * @return 实例对象
     */
    void insert(City city);

    /**
     * 修改数据
     *
     * @param city 实例对象
     * @return 实例对象
     */
    void update(City city);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(String id);

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo queryAll(Integer pageNum,Integer pageSize);

    /**
     * @return list
     */
    List<City> findAll();

    /**
     * json转为字符串
     * @return
     * @throws JsonProcessingException
     */
//    public String findJson() throws JsonProcessingException;

    void deleteAll(String ids);
}
