package com.rabbitmq.publish;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author InRoota
 * @date 2021-06-26  14:50
 */
public class PublishCustomer {

    public static final  String EXCHANGE_NAME = "exchange_name";
    public static final  String QUEUE_SMS = "sms";
    public static  final  String QUEUE_EMAIL = "email";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_SMS,true,false,false,null);
        channel.queueDeclare(QUEUE_EMAIL,true,false,false,null);

        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body, "UTF-8"));
            }
        };
        channel.basicConsume(QUEUE_SMS,true, consumer);
        channel.basicConsume(QUEUE_EMAIL,true, consumer);

    }
}
