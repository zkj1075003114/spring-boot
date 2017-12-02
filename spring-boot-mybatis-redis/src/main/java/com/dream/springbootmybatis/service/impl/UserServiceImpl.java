package com.dream.springbootmybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	@Override
	public int addAccount(String name, Double money) {
		Account account = new Account();
		account.setMoney(money);
		account.setName(name);
		updateAccount(7, "hah");
		return userMapper.insertAccount(account);
	}

	@Override
	public int updateAccount(Integer id, String name) {
		
		return userMapper.updateAccount(id, name);
	}

}
