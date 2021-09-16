package com.example.dao;

import com.example.pojo.Province;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author InRoota
 * @date 2021-06-24  13:33
 */
@Mapper
@Repository
public interface ProvinceDao {

    /**
     * 查询全部学生
     * @return
     */
    List<Province> findAll();

    Province findById(String id);

    Province findByName(String name);

    void save(Province province);
}
