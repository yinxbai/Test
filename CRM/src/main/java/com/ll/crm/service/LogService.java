package com.ll.crm.service;

import com.ll.crm.entity.Log;

import java.io.IOException;
import java.util.List;

/**
 * (Log)表服务接口
 *
 * @author makejava
 * @since 2021-06-30 09:53:00
 */
public interface LogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Log queryById(String id);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<Log> queryAll();

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    void insert(Log log);

    /**
     * 修改数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    Log update(Log log);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    void exportExcel() throws IOException;

}
