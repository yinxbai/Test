package com.xy.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xy.springcloud.service.DeptService;
import com.xy.springcloud.pojo.Dept;
import io.micrometer.core.instrument.Meter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author InRoota
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @HystrixCommand(fallbackMethod = "HystrixGet ")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id){
        Dept dept = deptService.queryById(id);

        if (dept ==null) {
            throw new RuntimeException("id=>" + id + ",不存该用户，信息无法查询");
        }
        return dept;
    }

    public Dept HystrixGet(@PathVariable("id")Integer id){
        Integer  deptNo = id;
        String deptName = "id=>"+id+"没有对应的信息，null--@Hystrix";
        String dbSource = "No db";
        return new Dept(deptNo,deptName,dbSource);
    }
}
