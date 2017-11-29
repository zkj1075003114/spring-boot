package com.dream.springbootjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dream.springbootjdbc.modle.User;
import com.dream.springbootjdbc.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="query/name", method=RequestMethod.GET)
	public User queryUser (String name) {
		User user = userService.getUserByName(name);
		return user;
	}
}
