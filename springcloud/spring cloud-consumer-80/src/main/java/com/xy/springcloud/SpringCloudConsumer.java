package com.xy.springcloud;

import com.xy.myrule.XyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author InRoota
 */
//Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用在意端口号
@SpringBootApplication
@EnableDiscoveryClient
//微服务启动类时加载配置
@RibbonClient(name = "SPRINGCLOUDPROVIDER",configuration = XyRule.class)
public class SpringCloudConsumer {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumer.class,args);
    }
}
