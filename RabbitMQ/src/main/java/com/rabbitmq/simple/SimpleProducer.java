package com.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author InRoota
 * @date 2021-06-25  16:20
 */
public class SimpleProducer {

    public static void main(String[] args) {

        try {
            //获取连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            //设置Host和Port
            factory.setHost("localhost");
            factory.setPort(5672);
            //创建会话
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            //声明队列
            //1.队列名；2.队列是否持久化；3.是否独占此链接；4.不使用自动删除；5.队列其他参数
            channel.queueDeclare("mes_info",true,false,false,null);
            for (int i=1; i<=13; i++){
                String body = "HELLO :"+i+": WORLD";
                //发送消息
                channel.basicPublish("","mes_info",null,body.getBytes(StandardCharsets.UTF_8));
            }
            channel.close();
            connection.close();
        }catch (TimeoutException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}
