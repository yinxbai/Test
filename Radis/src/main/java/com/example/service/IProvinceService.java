package com.example.service;

import com.example.pojo.Province;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

/**
 * @author InRoota
 * @date 2021-06-24  13:50
 */
public interface IProvinceService {

    /**
     * 查询全部城市
     * @return
     */
    List<Province> findAll();

    Province findById(String id);

    Province findByName(String name);

    void save(Province province);

    /**
     * json转为字符串
     * @return
     * @throws JsonProcessingException
     */
    public String findJson() throws JsonProcessingException;
}
