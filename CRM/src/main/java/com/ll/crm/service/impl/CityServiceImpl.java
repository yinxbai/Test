package com.ll.crm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ll.crm.entity.City;
import com.ll.crm.dao.CityDao;
import com.ll.crm.service.CityService;
import com.ll.crm.utils.JedisPoolUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;

/**
 * (City)表服务实现类
 *
 * @author makejava
 * @since 2021-06-30 09:52:40
 */
@Service("cityService")
public class CityServiceImpl implements CityService {
    @Resource
    private CityDao cityDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(cacheNames = "city",key = "{#id}",unless = "{#result==null}")
    public City queryById(String id) {
        return this.cityDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<City> queryAllByLimit(int offset, int limit) {
        return this.cityDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param city 实例对象
     * @return 实例对象
     */
    @Override
    @CacheEvict(cacheNames = "city",key ="01")
    public void insert(City city) {
        cityDao.insert(city);
    }

    /**
     * 修改数据
     *
     * @param city 实例对象
     * @return 实例对象
     */
    @Override
    public void update(City city) {
        this.cityDao.update(city);
        queryById(city.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(String id) {
       cityDao.deleteById(id);
    }

    @Override
    public PageInfo queryAll(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<City> list = cityDao.queryAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public List<City> findAll() {

        return cityDao.queryAll();
    }

    @Override
    @CacheEvict(cacheNames = "city",key ="01")
    public void deleteAll(String ids) {
        String[] _ids = ids.split(",");
        for(String id : _ids){
            deleteById(id);
        }
    }
}
