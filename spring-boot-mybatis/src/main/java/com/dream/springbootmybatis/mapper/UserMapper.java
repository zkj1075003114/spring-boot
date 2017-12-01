package com.dream.springbootmybatis.mapper;

import org.apache.ibatis.annotations.Select;

import com.dream.springbootmybatis.model.Account;


public interface UserMapper {

	@Select("select id,name,money from account where id = #{0}")
	Account getAccount(Integer id);

}
