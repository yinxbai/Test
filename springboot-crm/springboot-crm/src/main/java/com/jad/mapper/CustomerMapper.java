package com.jad.mapper;

import com.jad.po.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    public List<Customer> findAll(String search);
    public void save(Customer customer);
    public void deleteById(String id);
    public void batchDelete(String[] ids);
    public void update(Customer customer);
    public Customer findById(String id);
    public int findCount(String cityId);
}
