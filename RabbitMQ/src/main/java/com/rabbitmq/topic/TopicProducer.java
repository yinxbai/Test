package com.rabbitmq.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author InRoota
 * @date 2021-06-26  15:28
 */
public class TopicProducer {

    public static final  String EXCHANGE_NAME = "exchange_name";
    public static final  String QUEUE_SMS = "sms";
    public static  final  String QUEUE_EMAIL = "email";


    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        Connection connection =factory.newConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        channel.queueDeclare(QUEUE_SMS,true,false,false,null);
        channel.queueDeclare(QUEUE_EMAIL,true,false,false,null);
        //绑定交换机
        //1，队列名；2.交换机名；3.路由器key（参数标志）
        channel.queueBind(QUEUE_EMAIL,EXCHANGE_NAME,"#.sms.*");
        channel.queueBind(QUEUE_SMS,EXCHANGE_NAME,"#.sms.#");
        for (int i=0;i<=15;i++){

            String message = i+"通配符"+i;
            //等于key 类似key
            channel.basicPublish(EXCHANGE_NAME,"info.sms.send",null,message.getBytes(StandardCharsets.UTF_8));
        }
        channel.close();
        connection.close();
    }
}
