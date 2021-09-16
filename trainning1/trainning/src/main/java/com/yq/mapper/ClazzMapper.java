package com.yq.mapper;

import com.yq.po.Clazz;

import java.util.List;

public interface ClazzMapper {

    public List<Clazz> findAll();

    public void deleteById(String id);

    public void update(Clazz clazz);

    public void save(Clazz clazz);

    public Clazz findByName(String name);
}
