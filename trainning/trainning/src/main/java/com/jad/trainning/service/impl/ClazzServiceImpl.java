package com.jad.trainning.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jad.trainning.mapper.ClazzMapper;
import com.jad.trainning.po.Clazz;
import com.jad.trainning.service.IClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClazzServiceImpl implements IClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }

    @Override
    public void save(Clazz clazz) {
        System.out.println(clazz+"=======mapper");
        clazzMapper.save(clazz);
    }

    @Override
    public PageInfo queryByPage(Integer pageNum, Integer pageSize) {
       PageHelper.startPage(pageNum, pageSize);
       List<Clazz> list = clazzMapper.findAll();
       PageInfo pageInfo = new PageInfo(list);
       return pageInfo;
    }

    @Override
    public Clazz findById(String id) {
        return clazzMapper.findById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazzMapper.update(clazz);
    }

    @Override
    public void delete(String id) {
        clazzMapper.delete(id);
    }

    @Override
    @Transactional
    public void deleteAll(String ids){
        String[] array = ids.split(",");
        for(String id : array){
            delete(id);
        }
    }
}
