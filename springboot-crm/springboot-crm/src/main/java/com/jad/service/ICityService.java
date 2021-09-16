package com.jad.service;

import com.jad.po.City;

import java.util.List;

public interface ICityService {
    public List<City> findAll();
    public City findCityById(String id);
    public City findCityByName(String name);
    public void save(City city);
    public void deleteById(String id);
    public void update(City city);
    public void batchDelete(String[] ids);
}
