package com.rabbitmq.routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author InRoota
 * @date 2021-06-26  15:15
 */
public class RoutingProducer {
    public static final  String EXCHANGE_NAME = "exchange_name";
    public static final  String QUEUE_SMS = "sms";
    public static  final  String QUEUE_EMAIL = "email";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        Connection connection =factory.newConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        channel.queueDeclare(QUEUE_SMS,true,false,false,null);
        channel.queueDeclare(QUEUE_EMAIL,true,false,false,null);

        //指定队列（参数三）
        channel.queueBind(QUEUE_EMAIL,EXCHANGE_NAME,"sms");
        channel.queueBind(QUEUE_SMS,EXCHANGE_NAME,"email");

        for (int i=1; i<=15; i++){

            String message = i+"HELLO WORLD"+i;
            channel.basicPublish(EXCHANGE_NAME,"sms-fo",null,message.getBytes(StandardCharsets.UTF_8));
        }
            channel.close();
            connection.close();
    }
}
