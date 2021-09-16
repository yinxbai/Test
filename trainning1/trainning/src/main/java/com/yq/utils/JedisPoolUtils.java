package com.yq.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author InRoota
 * @date 2021-06-24  13:41
 */

/**
 * 链接池工具类,作用获取链接对象
 * @author 54020
 */
public class JedisPoolUtils {

    private static JedisPool jedisPool;
    static {

        //读取jedis配置文件(通过反射拿到当前类加载器对象，然后加载配置文件)
        InputStream inputStream = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        //通过Properties 工具类 读取数据
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将读取的配置文件信息配置到JedisPoolConfig 对象中
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.valueOf(properties.getProperty("maxTotal")));
        config.setMaxIdle(Integer.valueOf(properties.getProperty("maxIdle")));
        //初始化 JedisPool
        jedisPool = new JedisPool(config, properties.getProperty("host"), Integer.valueOf(properties.getProperty("port")));
    }
    /**
     * 从池子中拿到一个链接对象
     * @return
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
