package com.xy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author InRoota
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEureka02 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEureka02.class,args);
    }
}
