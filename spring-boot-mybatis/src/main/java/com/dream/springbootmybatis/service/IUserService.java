package com.dream.springbootmybatis.service;

import com.dream.springbootmybatis.model.Account;

public interface IUserService {

	/**
	 * 获取用户账户信息
	 * @param id
	 * @return
	 */
	Account getAccount(Integer id);

}
