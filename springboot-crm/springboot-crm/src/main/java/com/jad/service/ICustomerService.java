package com.jad.service;

import com.github.pagehelper.PageInfo;
import com.jad.po.Customer;
import com.jad.po.SysUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICustomerService {
    public PageInfo findAll(Integer pageNum, Integer pageSize,String search);
    public void save(Customer customer);
    public void deleteById(String id);
    public void batchDelete(String[] ids);
    public void update(Customer customer);
    public Customer findById(String id);
    public void export(HttpServletRequest request, HttpServletResponse response);
    public void importExcel(HttpServletRequest request, HttpServletResponse response);
    public void download(HttpServletRequest request, HttpServletResponse response);
    public int findCount(String cityId);

}
