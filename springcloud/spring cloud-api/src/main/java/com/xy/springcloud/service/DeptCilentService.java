package com.xy.springcloud.service;

import com.xy.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


/**
 * @author InRoota
 */
@Component
@FeignClient(value = "SpringCloudProviderHystrix")
public interface DeptCilentService {

    @GetMapping("dept/get/{id}")
    public Dept queryById(@PathVariable("id") Integer id);

    @GetMapping("/dept/list")
    public List<Dept> queryAll();

    @PostMapping("/dept/add")
    public Dept addDept(Dept dept);
}
