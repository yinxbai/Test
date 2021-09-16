package com.jad.service.impl;

import com.jad.mapper.UserMapper;
import com.jad.po.User;
import com.jad.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author InRoota
 * @date 2021-05-26  21:46
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User findById(int id) {
        return mapper.findById(id);
    }

    @Override
    public List<User> findAll() {
        return mapper.findAll();
    }

    @Override
    public void deleteById(int id) {
        mapper.deleteById(id);
    }
}
