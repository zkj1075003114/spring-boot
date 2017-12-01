package com.dream.springbootmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dream.springbootmybatis.model.Account;
import com.dream.springbootmybatis.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/v1/id")
	public String getAccount(@RequestParam(value="id") Integer id) {
		
		Account account = userService.getAccount(id);
		
		return account.toString();
		
	}
}
