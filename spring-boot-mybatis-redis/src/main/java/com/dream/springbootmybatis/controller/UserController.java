package com.dream.springbootmybatis.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dream.springbootmybatis.config.redis.BaseRedisTemplate;
import com.dream.springbootmybatis.model.Account;
import com.dream.springbootmybatis.service.IUserService;
import com.dream.springbootmybatis.utils.RedisUtil;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
//	@Autowired
//	private RedisUtil redisUtil;
//	@Autowired
//	private XyyRedisTemplate xyyRedisTemplate;
	
	@Autowired
	BaseRedisTemplate baseRedisTemplate;
	
	@RequestMapping(value="/v1/id", method=RequestMethod.GET)
	public String getAccount(@RequestParam(value="id") Integer id) {
		
		Account account = userService.getAccount(id);
		
		return account.toString();
		
	}
	
	@RequestMapping(value="/v1/add", method=RequestMethod.POST)
	public boolean addAccount(@RequestParam(value="name") String name,
			@RequestParam(value="money") Double money) {
		
		int count = userService.addAccount(name, money);
		if (count > 0) {
			return true;		
		}
		return false;
		
	}
	
	@RequestMapping(value="/v1/update", method=RequestMethod.POST)
	public boolean updateAccount(@RequestParam(value="id") Integer id,
			@RequestParam(value="name") String name) {
		
		int count = userService.updateAccount(id, name);
		if (count > 0) {
			return true;		
		}
		return false;
		
	}
	
	@RequestMapping(value="/test", method=RequestMethod.POST)
	public Object testRedis() {
		baseRedisTemplate.set("hello", "你好!");
		Object object = baseRedisTemplate.get("hello");
//		xyyRedisTemplate.set("base_", "hello", "你好!");
//		Object object = xyyRedisTemplate.get("base_","hello");
		return object;
		
	}
}
