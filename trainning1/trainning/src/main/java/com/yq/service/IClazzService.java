package com.yq.service;

import com.yq.po.Clazz;

import java.util.List;

public interface IClazzService {

    public List<Clazz> findAll();

    public void deleteById(String id);

    public void update(Clazz clazz);

    public void save(Clazz clazz);

    public Clazz findByName(String name);

    public void bacthDelete(String ids[]);
}
