package com.xy.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author InRoota
 */
@SpringBootApplication
@EnableEurekaClient     // 注册Eureka
@EnableDiscoveryClient  //服务发现
@EnableCircuitBreaker //支持熔断机制
public class SpringCloudProviderHystrix01 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderHystrix01.class,args);
    }
}
