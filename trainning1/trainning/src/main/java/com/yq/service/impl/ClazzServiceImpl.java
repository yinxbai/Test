package com.yq.service.impl;

import com.yq.mapper.ClazzMapper;
import com.yq.po.Clazz;
import com.yq.service.IClazzService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClazzServiceImpl implements IClazzService {

    @Resource
    private ClazzMapper clazzMapper;
    @Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }

    @Override
    public void deleteById(String id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazzMapper.update(clazz);
    }

    @Override
    public void save(Clazz clazz) {
        clazzMapper.save(clazz);
    }

    @Override
    public Clazz findByName(String name) {
        return clazzMapper.findByName(name);
    }

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public void bacthDelete(String[] ids) {
        for (String s : ids) {
            clazzMapper.deleteById(s);
        }

    }
}
