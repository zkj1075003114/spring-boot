package com.dream.springbootmybatis.config.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * redis主从连接池配置bean
 * @author zhoukuanjians
 *
 */
@Component
@ConfigurationProperties(value = "jedisPool")
public class RedisPoolConfig extends AbstractSettings {

	/**
	 * 缓存最大连接数
	 */
	private Integer maxTotal;
	/**
	 * 缓存最大空闲数
	 */
	private Integer maxIdle;
	/**
	 * 缓存最小空闲数
	 */
	private Integer minIdle;
	
	/**
	 * 最大等待空闲时间
	 */
	private Integer maxWaitMillis;
	
	private Boolean testOnBorrow;
	
	private Boolean testWhileIdle;
	
	private Boolean testOnReturn;
	
	private Boolean blockWhenExhausted;
	
	private Integer numTestsPerEvictionRun;
	
	private Integer timeBetweenEvictionRunsMillis;
	
	private Integer softMinEvictableIdleTimeMillis;
	
	
	/**
	 * 最小驱逐空闲时间
	 */
	private Integer minEvictableIdleTimeMillis;
	
	public Integer getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(Integer minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public Integer getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(Integer maxTotal) {
		this.maxTotal = maxTotal;
	}

	public Integer getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}

	public Integer getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(Integer minIdle) {
		this.minIdle = minIdle;
	}

	public Integer getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(Integer maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public Boolean getTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(Boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public Boolean getTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(Boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public Boolean getTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(Boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public Boolean getBlockWhenExhausted() {
		return blockWhenExhausted;
	}

	public void setBlockWhenExhausted(Boolean blockWhenExhausted) {
		this.blockWhenExhausted = blockWhenExhausted;
	}

	public Integer getNumTestsPerEvictionRun() {
		return numTestsPerEvictionRun;
	}

	public void setNumTestsPerEvictionRun(Integer numTestsPerEvictionRun) {
		this.numTestsPerEvictionRun = numTestsPerEvictionRun;
	}

	public Integer getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(
			Integer timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public Integer getSoftMinEvictableIdleTimeMillis() {
		return softMinEvictableIdleTimeMillis;
	}

	public void setSoftMinEvictableIdleTimeMillis(
			Integer softMinEvictableIdleTimeMillis) {
		this.softMinEvictableIdleTimeMillis = softMinEvictableIdleTimeMillis;
	}
	
}
