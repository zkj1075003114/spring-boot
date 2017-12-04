//package com.dream.springbootmybatis.config.redis;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.JedisCluster;
//
//@Configuration  
//public class JedisClusterConfig {
//	
//	@Autowired
//	private RedisHostConfig redisHostConfig;
//
//	@Bean  
//    public JedisCluster getJedisCluster() {  
//        String[] serverArray = redisHostConfig.getClusterNodes().split(",");//获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)  
//        Set<HostAndPort> nodes = new HashSet<>();  
//  
//        for (String ipPort : serverArray) {  
//            String[] ipPortPair = ipPort.split(":");  
//            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));  
//        }  
//  
//        return new JedisCluster(nodes, redisHostConfig.getClusterTimeout(),redisHostConfig.getMaxRedirects());  
//    }  
//}
