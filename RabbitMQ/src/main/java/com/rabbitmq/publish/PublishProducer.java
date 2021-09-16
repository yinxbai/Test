package com.rabbitmq.publish;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.lang.reflect.Member;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author InRoota
 * @date 2021-06-26  14:23
 */
public class PublishProducer {

    public static final  String EXCHANGE_NAME = "exchange_name";
    public static final  String QUEUE_SMS = "sms";
    public static  final  String QUEUE_EMAIL = "email";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        Connection connection =factory.newConnection();

        Channel channel = connection.createChannel();
        //声明交换机
        //1.交换机名；2.交换机类型
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        //队列声明
        //1.队列名称；2.队列是否持久化；2.是否独占连接资源；4.是否删除此对了；5.其他参数
        channel.queueDeclare(QUEUE_SMS,true,false,false,null);
        channel.queueDeclare(QUEUE_EMAIL,true,false,false,null);
        //绑定交换机
        //1，队列名；2.交换机名；3.路由器key（参数标志）
        channel.queueBind(QUEUE_EMAIL,EXCHANGE_NAME,"");
        channel.queueBind(QUEUE_SMS,EXCHANGE_NAME,"");
        for (int i=0;i<=15;i++){

            String message = i+"HELLO WORLD"+i;
            channel.basicPublish(EXCHANGE_NAME,"sms",null,message.getBytes(StandardCharsets.UTF_8));
        }
        channel.close();
        connection.close();
    }


}
