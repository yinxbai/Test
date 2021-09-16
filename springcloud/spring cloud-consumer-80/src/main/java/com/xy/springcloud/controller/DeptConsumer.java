package com.xy.springcloud.controller;

import com.xy.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author InRoota
 */
@RestController
public class DeptConsumer {

    /**
     * (url,实体 Map ,class<T> responseType
     */
    @Autowired
    private RestTemplate restTemplate;

    //ribbon实现这里地址应为变量，通过服务名访问
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SpringCloudProvider";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> deptList(){
        return (List<Dept>) restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

    @RequestMapping("/consumer/dept/add")
    public ResponseEntity<Boolean> addDept(Dept dept){
        return restTemplate.postForEntity(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }
}
