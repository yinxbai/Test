package com.jad.trainning.mapper;

import com.jad.trainning.po.Clazz;

import java.util.List;

public interface ClazzMapper {
    public List<Clazz> findAll();
    public void save(Clazz clazz);
    public Clazz findById(String id);
    public void update(Clazz clazz);
    public void delete(String id);
}
