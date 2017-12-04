/*
* Copyright (c) 2016-2030 SHENZHEN TOMTOP SCIENCE AND TECHNOLOGY DEVELOP CO., LTD. All rights reserved.
*
* 注意：本内容仅限于深圳市通拓科技研发有限公司内部传阅，禁止外泄以及用于其他的商业目的 
*/

package com.dream.springbootmybatis.config.redis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @author zhoukuanjians
 *
 */
@Configuration
public class RedisCluster {
	
	@Autowired
	protected RedisPoolConfig redisPoolConfig;
	
	@Autowired
	protected RedisHostConfig redisHostConfig;
	
	@Bean(name = "jedisPoolConfig")
	public JedisPoolConfig getJedisPoolConfig(){
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(redisPoolConfig.getMaxTotal());
		jedisPoolConfig.setMaxIdle(redisPoolConfig.getMaxIdle());
		jedisPoolConfig.setMinIdle(redisPoolConfig.getMinIdle());
		jedisPoolConfig.setMaxWaitMillis(redisPoolConfig.getMaxWaitMillis());
		jedisPoolConfig.setTestOnBorrow(redisPoolConfig.getTestOnBorrow());
		jedisPoolConfig.setTestWhileIdle(redisPoolConfig.getTestWhileIdle());
		jedisPoolConfig.setTestOnReturn(redisPoolConfig.getTestOnReturn());
		jedisPoolConfig.setBlockWhenExhausted(redisPoolConfig.getBlockWhenExhausted());
		jedisPoolConfig.setNumTestsPerEvictionRun(redisPoolConfig.getNumTestsPerEvictionRun());
		jedisPoolConfig.setTimeBetweenEvictionRunsMillis(redisPoolConfig.getTimeBetweenEvictionRunsMillis());
		jedisPoolConfig.setMinEvictableIdleTimeMillis(redisPoolConfig.getMinEvictableIdleTimeMillis());
		return jedisPoolConfig;
	}

	@Bean(name = "redisClusterConfiguration")
	public RedisClusterConfiguration getClusterConfiguration() {
		Map<String, Object> config = new HashMap<String, Object>();
		config.put("spring.redis.cluster.nodes", redisHostConfig.getClusterNodes().trim());
		config.put("spring.redis.cluster.timeout", redisHostConfig.getClusterTimeout());
		config.put("spring.redis.cluster.max-redirects",redisHostConfig.getMaxRedirects());
		return new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", config));
	}

	@Bean(name = "redisConnectionFactory")
	public RedisConnectionFactory connectionFactory(
			@Qualifier("redisClusterConfiguration") RedisClusterConfiguration redisClusterConfiguration,
			@Qualifier("jedisPoolConfig") JedisPoolConfig jedisPoolConfig
			) {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration);
		jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
		jedisConnectionFactory.setUsePool(true);
		jedisConnectionFactory.afterPropertiesSet();
		return jedisConnectionFactory;
	}

	public @Bean RedisTemplate<?, ?> redisTemplate(
			@Qualifier("redisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
		template.setConnectionFactory(redisConnectionFactory);
		template.setKeySerializer(new StringRedisSerializer());
		template.afterPropertiesSet();
		return template;
	}

	public @Bean("transtionTempRedislate") RedisTemplate<String, Integer> transtionRedisTemplate(
			@Qualifier("redisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Integer> template = new RedisTemplate<String, Integer>();
		template.setConnectionFactory(redisConnectionFactory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setEnableTransactionSupport(true);// 开启事务
		template.afterPropertiesSet();
		return template;
	}

	@Bean(name = "baseRedisTemplate")
	public BaseRedisTemplate redisTemplateResult2(
			@Qualifier("redisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
		BaseRedisTemplate redisTemplate = new BaseRedisTemplate();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
//		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setConnectionFactory(redisConnectionFactory);
//		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
}
