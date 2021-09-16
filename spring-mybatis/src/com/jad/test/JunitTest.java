package com.jad.test;

import com.jad.po.User;
import com.jad.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author InRoota
 * @date 2021-05-26  21:55
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JunitTest {

    @Autowired
    private IUserService service;

    @Test
    public void testFindById() {
        User user = service.findById(3);
        System.out.println(user);
    }
    @Test
    public void testFindAll() {
        List<User> list = service.findAll();
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            System.out.println(user);
        }
    }
    @Test
    public void testDeleteById() {
        service.deleteById(2);
    }
}
