package com.jad.dao;

import com.jad.po.User;

import java.util.List;

public interface IUserDao {
    public User save(User user);
    public void delete(int id);
    public void update(User user);
    public List<User> findAll();
    public User findById(int id);
    public List<User> findByName(String name);
    public  List<User> queryList();
}
