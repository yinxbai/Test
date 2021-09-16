package com.xy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author InRoota
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class SpringCloudProvider01 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProvider01.class,args);
    }
}
