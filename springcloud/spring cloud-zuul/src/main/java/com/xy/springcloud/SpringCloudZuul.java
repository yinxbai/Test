package com.xy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @author InRoota
 */
@SpringBootApplication
@EnableZuulServer
public class SpringCloudZuul {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuul.class,args);
    }
}
