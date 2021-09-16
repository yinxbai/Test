package com.yq.rabbit.listener;

import com.yq.rabbit.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author InRoota
 * @date 2021-06-26  17:15
 */
@Component
public class CustomerListener {

    @RabbitListener(queues = RabbitmqConfig.QUEUE_SMS)
    public void receiveSms(String body){
        System.out.println("SMS:"+body);
    }

    @RabbitListener(queues = RabbitmqConfig.QUEUE_EMAIL)
    public void receiveEmail(String body){
        System.out.println("Email:"+body);
    }
}
