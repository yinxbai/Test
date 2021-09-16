package com.xy.springcloud.service;

import com.xy.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
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
public class DeptCilentServiceFailBack implements FallbackFactory {


    @Override
    public DeptCilentService create(Throwable throwable) {
        return new DeptCilentService() {
            @Override
            public Dept queryById(Integer id) {
                return new Dept()
                        .setId(id)
                        .setDeptName("id=>"+id+"没有对应的信息，客户端提供了降级信息，现在这个服务已经关闭")
                        .setDbSource("Null 无数据库匹配");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public Dept addDept(Dept dept) {
                return null;
            }
        };
    }
}
