package com.jad.trainning.service;

import com.github.pagehelper.PageInfo;
import com.jad.trainning.po.Clazz;

import java.util.List;

public interface IClazzService {
    public List<Clazz> findAll();
    public void save(Clazz clazz);
    public PageInfo queryByPage(Integer pageNum, Integer pageSize);
    public Clazz findById(String id);
    public void update(Clazz clazz);
    public void delete(String id);
    public void deleteAll(String ids);
}
