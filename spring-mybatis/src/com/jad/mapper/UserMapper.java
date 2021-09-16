package com.jad.mapper;

import com.jad.po.User;

import java.util.List;

/**
 * @author InRoota
 * @date 2021-05-26  21:34
 */
public interface UserMapper {
    /**
     * Id查询用户
     * @param id
     * @return
     */
    public User findById(int id);

    /**
     * 查找全部
     * @return
     */
    public List<User> findAll();

    /**
     * 删除ID
     * @param id
     */
    public void deleteById(int id);
}
