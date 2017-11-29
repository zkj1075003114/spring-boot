package com.dream.springbootjdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.springbootjdbc.dao.IUserDao;
import com.dream.springbootjdbc.modle.User;
import com.dream.springbootjdbc.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	@Override
	public User getUserByName(String name) {
		return userDao.getUserByName(name);
	}

}
