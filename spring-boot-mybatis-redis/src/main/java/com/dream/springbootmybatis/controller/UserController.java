package com.dream.springbootmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dream.springbootmybatis.model.Account;
import com.dream.springbootmybatis.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
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
}
