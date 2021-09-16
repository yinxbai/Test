package com.xy.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author InRoota
 */
@Configuration
public class XyRule {


    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
