package com.xy.springcloud.dao;

import com.xy.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author InRoota
 */
@Mapper
@Repository
public interface DeptDao {

    /**
     * 添加单条数据
     * @param dept
     * @return
     */
    public boolean addDept(Dept dept);

    /**
     * 查询单条数据
     * @param id
     * @return
     */
    public Dept queryById(Integer id);

    /**
     * 查询全部记录
     * @return
     */
    public List<Dept> queryAll();
}
