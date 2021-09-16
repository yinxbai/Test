package com.xy.springcloud.controller;

import com.xy.springcloud.service.DeptService;
import com.xy.springcloud.pojo.Dept;
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
import java.util.UnknownFormatConversionException;

/**
 * @author InRoota
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    Logger log = LoggerFactory.getLogger(DeptController.class);

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Integer id){
        Dept dept = deptService.queryById(id);
        if (dept ==null){
            throw  new RuntimeException("Fail");
        }
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> deptList(){
        return deptService.queryAll();
    }

    //注册微服务 获取消息
    @GetMapping("/dept/discovery")
    public Object discovery() {
        //获取微服务列表清单
        List<String> list = client.getServices();
        log.debug("discovery->" + String.valueOf(list));

        //得到具体微服务清单
        List<ServiceInstance> serviceInstances = client.getInstances("SpringCloudProvider");
        serviceInstances.stream().forEach(serviceInstance ->
                log.debug(serviceInstance.getHost() + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri() + "\t" + serviceInstance.getServiceId()));
        return this.client;
    }
}
