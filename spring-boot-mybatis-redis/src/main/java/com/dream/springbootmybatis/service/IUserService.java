package com.dream.springbootmybatis.service;

import com.dream.springbootmybatis.model.Account;

public interface IUserService {

	/**
	 * 获取用户账户信息
	 * @param id
	 * @return
	 */
	Account getAccount(Integer id);

	/**
	 * 插入账户信息
	 * @param name
	 * @param money
	 * @return
	 */
	int addAccount(String name, Double money);

	/**
	 * 修改账户信息
	 * @param id
	 * @param name
	 * @return
	 */
	int updateAccount(Integer id, String name);

}
