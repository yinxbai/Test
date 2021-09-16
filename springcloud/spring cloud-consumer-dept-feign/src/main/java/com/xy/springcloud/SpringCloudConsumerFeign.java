package com.xy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author InRoota
 */
//Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用在意端口号
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.xy.springcloud"})
public class SpringCloudConsumerFeign {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerFeign.class,args);
    }
}
