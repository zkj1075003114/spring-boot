package com.dream.springbootmybatis.config.redis;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * 
 * @author zhoukuanjians
 *
 */
public class BaseRedisTemplate  extends RedisTemplate<Serializable, Object>{

	
	/**
	 * 批量删除对应的value
	 * 
	 * @param keys
	 */
	public void remove(final String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}
	/**
	 * 批量删除key
	 * 
	 * @param pattern
	 */
	public void removePattern(final String pattern) {
		Set<Serializable> keys = this.keys(pattern);
		if (keys.size() > 0)
			this.delete(keys);
	}
	/**
	 * 删除对应的value
	 * 
	 * @param key
	 */
	public void remove(final String key) {
		if (exists(key)) {
			this.delete(key);
		}
	}
	/**
	 * 判断缓存中是否有对应的value
	 * 
	 * @param key
	 * @return
	 */
	public boolean exists(final String key) {
		return this.hasKey(key);
	}
	/**
	 * 读取缓存
	 * 
	 * @param key
	 * @return
	 */
	public Object get(final String key) {
		Object result = null;
		ValueOperations<Serializable, Object> operations = this.opsForValue();
		result = operations.get(key);
		return result;
	}
	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(final String key, Object value) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = this.opsForValue();
			operations.set(key, value);
			result = true;
		} catch (Exception e) {
			 logger.error("Set key error : "+e);  
		}
		return result;
	}
	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(final String key, Object value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations<Serializable, Object> operations = this.opsForValue();
			operations.set(key, value);
			this.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			logger.error("Set key error : "+e);  
		}
		return result;
	}
	
	public Boolean setData(String key ,byte bytes[]){  
		boolean result = false;
        try {  
        	super.getConnectionFactory().getConnection().set(key.getBytes(), bytes);
        	result = true;
        } catch (Exception e) {  
            logger.error("Set key error : "+e);  
        }
		return result;  
    } 
	
	public  byte[]  getData(String key){  
		byte[] byties = null;
        try {  
        	 byties = super.getConnectionFactory().getConnection().get(key.getBytes());
        	
        } catch (Exception e) {  
            logger.error("Set key error : "+e);  
        }
		return byties;  
    }
}
