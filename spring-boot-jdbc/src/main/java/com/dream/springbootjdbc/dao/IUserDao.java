package com.dream.springbootjdbc.dao;

import com.dream.springbootjdbc.modle.User;

public interface IUserDao {

	User getUserByName(String name);

}
