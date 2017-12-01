package com.dream.springbootmybatis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.jdbc")
public class JdbcConfig {

	private String driver;
	private String url;
	private String username;
	private String password;
	
	private Integer pgmaxActive;
	private Integer pginitialSize;
	private Integer pgminIdle;
	
	private Integer maxActive;
	private Integer initialSize;
	private Integer maxIdle;
	private Integer minIdle;
	private Integer maxWait;
	private Integer timeBetweenEvictionRunsMillis;
	private Boolean removeAbandoned;
	private Integer removeAbandonedTimeout;
	private Integer minEvictableIdleTimeMillis;
	private String validationQuery;
	private Boolean testOnBorrow;
	private Boolean testOnReturn;
	
	
	public JdbcConfig() {
		
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPgmaxActive() {
		return pgmaxActive;
	}
	public void setPgmaxActive(Integer pgmaxActive) {
		this.pgmaxActive = pgmaxActive;
	}
	public Integer getPginitialSize() {
		return pginitialSize;
	}
	public void setPginitialSize(Integer pginitialSize) {
		this.pginitialSize = pginitialSize;
	}
	public Integer getPgminIdle() {
		return pgminIdle;
	}
	public void setPgminIdle(Integer pgminIdle) {
		this.pgminIdle = pgminIdle;
	}
	public Integer getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(Integer maxActive) {
		this.maxActive = maxActive;
	}
	public Integer getInitialSize() {
		return initialSize;
	}
	public void setInitialSize(Integer initialSize) {
		this.initialSize = initialSize;
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
	public Integer getMaxWait() {
		return maxWait;
	}
	public void setMaxWait(Integer maxWait) {
		this.maxWait = maxWait;
	}
	public Integer getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}
	public void setTimeBetweenEvictionRunsMillis(Integer timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}
	public Boolean getRemoveAbandoned() {
		return removeAbandoned;
	}
	public void setRemoveAbandoned(Boolean removeAbandoned) {
		this.removeAbandoned = removeAbandoned;
	}
	public Integer getRemoveAbandonedTimeout() {
		return removeAbandonedTimeout;
	}
	public void setRemoveAbandonedTimeout(Integer removeAbandonedTimeout) {
		this.removeAbandonedTimeout = removeAbandonedTimeout;
	}
	public Integer getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}
	public void setMinEvictableIdleTimeMillis(Integer minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}
	public String getValidationQuery() {
		return validationQuery;
	}
	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}
	public Boolean getTestOnBorrow() {
		return testOnBorrow;
	}
	public void setTestOnBorrow(Boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	public Boolean getTestOnReturn() {
		return testOnReturn;
	}
	public void setTestOnReturn(Boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}
	
}
