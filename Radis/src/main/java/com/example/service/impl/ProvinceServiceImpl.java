package com.example.service.impl;

import com.example.dao.ProvinceDao;
import com.example.pojo.Province;
import com.example.service.IProvinceService;
import com.example.utils.JedisPoolUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author InRoota
 * @date 2021-06-24  13:51
 */
@Service
public class ProvinceServiceImpl implements IProvinceService {

    @Resource
    private ProvinceDao provinceDao;

    @Override
    @Cacheable(cacheNames = "student",key = "10086" ,unless = "#result=null")
    public List<Province> findAll() {
        return provinceDao.findAll();
    }

    @Override
    public Province findById(String id) {

        return provinceDao.findById(id);
    }

    @Override
    public Province findByName(String name) {

        return provinceDao.findByName(name);
    }

    @Override
    @CacheEvict(cacheNames = "province" , key = "10086")
    public void save(Province province) {

        provinceDao.save(province);
    }

    @Override
    public String findJson() throws JsonProcessingException {
        Jedis jedis = JedisPoolUtils.getJedis();

        String json = jedis.get("province");
        if (json == null || json.length() == 0 ){
            System.out.println("首次从mysql查询数据，redis没有缓存....");
            List<Province> list = provinceDao.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            json =objectMapper.writeValueAsString(list);
            jedis.set("province",json);
            jedis.close();
        }else {
            System.out.println("可以取出数据，作为缓存对象");
        }
        return json;
    }
}
