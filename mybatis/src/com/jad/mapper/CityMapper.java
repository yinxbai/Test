package com.jad.mapper;

import com.jad.po.City;

/**
 * @author InRoota
 * @date 2021-05-26  19:58
 */
public interface CityMapper {
    /**
     * 查询客户
     * @param id
     * @return
     */
    public City findById(int id);
}
