package com.jad.service;

import com.jad.po.User;

import java.util.List;

/**
 * @author InRoota
 * @date 2021-05-26  21:45
 */
public interface IUserService {
    public User findById(int id);
    public List<User> findAll();
    public void deleteById(int id);
}
