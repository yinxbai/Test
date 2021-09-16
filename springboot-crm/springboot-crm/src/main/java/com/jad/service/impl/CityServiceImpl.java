package com.jad.service.impl;

import com.jad.mapper.CityMapper;
import com.jad.po.City;
import com.jad.service.ICityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CityServiceImpl implements ICityService {
    @Resource
    private CityMapper cityMapper;

    @Override
    public List<City> findAll() {
        return cityMapper.findAll();
    }

    @Override
    public City findCityById(String id) {
        return cityMapper.findCityById(id);
    }

    @Override
    public City findCityByName(String name) {
        return cityMapper.findCityByName(name);
    }

    @Override
    public void save(City city) {
        cityMapper.save(city);
    }

    @Override
    public void deleteById(String id) {
        cityMapper.deleteById(id);
    }

    @Override
    public void update(City city) {
        cityMapper.update(city);
    }

    @Override
    public void batchDelete(String[] ids) {
        for (String s : ids) {
            cityMapper.deleteById(s);
        }
    }
}
