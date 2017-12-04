/*
* Copyright (c) 2015-2018 SHENZHEN TOMTOP SCIENCE AND TECHNOLOGY DEVELOP CO., LTD. All rights reserved.
*
* 注意：本内容仅限于深圳市通拓科技研发有限公司内部传阅，禁止外泄以及用于其他的商业目的 
*/
package com.dream.springbootmybatis.config.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "redis")
public class RedisHostConfig extends AbstractSettings{
	
	/**
	 * host
	 */
	private String clusterNodes;	//="redis.cluster.com:7000,redis.cluster.com:7001,redis.cluster.com:7002";
	
	/**
	 * 超时
	 */
	private Integer clusterTimeout;	//=20000;
	
	/**
	 * 
	 */
	private Integer maxRedirects;	//=8;
	
	/**
	 * 
	 */
	private Integer normalExpire;

	public String getClusterNodes() {
		return clusterNodes;
	}

	public void setClusterNodes(String clusterNodes) {
		this.clusterNodes = clusterNodes;
	}

	public Integer getClusterTimeout() {
		return clusterTimeout;
	}

	public void setClusterTimeout(Integer clusterTimeout) {
		this.clusterTimeout = clusterTimeout;
	}

	public Integer getMaxRedirects() {
		return maxRedirects;
	}

	public void setMaxRedirects(Integer maxRedirects) {
		this.maxRedirects = maxRedirects;
	}

	public Integer getNormalExpire() {
		return normalExpire;
	}

	public void setNormalExpire(Integer normalExpire) {
		this.normalExpire = normalExpire;
	}

	
}
