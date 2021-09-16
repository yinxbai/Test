package com.jad.mapper;

import com.jad.po.City;
import com.jad.po.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityMapper {
    public List<City> findAll();
    public City findCityById(String id);
    public City findCityByName(String name);
    public void save(City city);
    public void deleteById(String id);
    public void update(City city);
}
