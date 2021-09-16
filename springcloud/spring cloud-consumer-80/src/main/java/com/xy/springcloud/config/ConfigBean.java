package com.xy.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author InRoota
 */
@Configuration
public class ConfigBean {

    //配置负载均衡实现restTemplate
    // IRule
    // RoundRobinRule
    // random rule
    // retry rule ：轮询失败会继续
    // AvailabilityFilteringRule : 过滤，会跳闸，访问故障服务，对剩下项目进行轮询
    @Bean
    @LoadBalanced   //ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
