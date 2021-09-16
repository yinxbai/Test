package com.ll.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ll.crm.entity.Customer;
import com.ll.crm.dao.CustomerDao;
import com.ll.crm.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Customer)表服务实现类
 *
 * @author makejava
 * @since 2021-06-30 09:52:54
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Customer queryById(String id) {
        return this.customerDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Customer> queryAllByLimit(int offset, int limit) {
        return this.customerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param customer 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(Customer customer) {
        customerDao.insert(customer);
    }

    /**
     * 修改数据
     *
     * @param customer 实例对象
     * @return 实例对象
     */
    @Override
    public Customer update(Customer customer) {
        this.customerDao.update(customer);
        return this.queryById(customer.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(String id) {
        customerDao.deleteById(id);
    }

    @Override
    public void deleteAll(String ids) {
        String _ids[] = ids.split(",");
        for (String id:_ids) {
            deleteById(id);
        }
    }

    @Override
    public PageInfo findAll(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Customer> list = customerDao.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public List<Customer> list() {

        return customerDao.findAll();
    }
}
