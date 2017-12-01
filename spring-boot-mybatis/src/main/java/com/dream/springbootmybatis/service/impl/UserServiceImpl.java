package com.dream.springbootmybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.springbootmybatis.mapper.UserMapper;
import com.dream.springbootmybatis.model.Account;
import com.dream.springbootmybatis.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Account getAccount(Integer id) {
		
		return userMapper.getAccount(id);
	}

}
