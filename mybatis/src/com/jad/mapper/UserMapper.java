package com.jad.mapper;

import com.jad.po.City;
import com.jad.po.User;

import java.util.List;
import java.util.Map;

/**
 * @author 54020
 */
public interface UserMapper {

    /**
     * 查询用户Id
     * @param id
     * @return
     */
    public Map<String,Object> findUserById(Integer id);

    /**
     * 关键名称查询
     * @param name
     * @return
     */
    public List<User> findByName(String name);

    /**
     * Id删除
     * @param id
     */
    public void deleteById(Integer id);

    /**
     * 保存
     * @param user
     * @return
     */
    public void save(User user);

    /**
     * 修改
     * @param user
     */
    public void update(User user);

    /**
     * 显示
     * @return
     */
    public List<User> findAll();

    /**
     * 查询
     * @param user
     * @return
     */
    public List<User> search(User user);

    /**
     * 查询全部
     * @return
     */
    public List<User> queryList();
    public City queryCity(int id);
}
