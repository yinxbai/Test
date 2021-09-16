package com.yq.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author InRoota
 * @date 2021-06-26  16:30
 */
@Configuration
public class RabbitmqConfig {
    public static final String EXCHANGE_NAME = "exchange_java";
    public static final String QUEUE_SMS = "sms";
    public static final String QUEUE_EMAIL = "email";

    /**交换机声明
     *
     * @return
     */
    @Bean(EXCHANGE_NAME)
    public Exchange exchangeDeclare(){
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    /**队列声明
     *
     * @return
     */
    @Bean(QUEUE_SMS)
    public Queue queueDeclares(){
        return QueueBuilder.durable(QUEUE_SMS).build();
    }

    @Bean(QUEUE_EMAIL)
    public Queue queueDeclare(){
        return QueueBuilder.durable(QUEUE_EMAIL).build();
    }

    /**
     * 绑定交换机与队列
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding bindingS(@Qualifier(QUEUE_SMS) Queue queue, @Qualifier(EXCHANGE_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("#.sms.#").noargs();
    }

    @Bean
    public Binding binding(@Qualifier(QUEUE_EMAIL) Queue queue, @Qualifier(EXCHANGE_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("#.email.#").noargs();
    }

}
