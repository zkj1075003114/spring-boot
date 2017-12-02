package com.dream.springbootmybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dream.springbootmybatis.model.Account;


public interface UserMapper {

	@Select("select id,name,money from account where id = #{0}")
	Account getAccount(Integer id);

	@Insert("insert into account (`name`,`money`) values (#{name}, #{money})")
	@Options(useGeneratedKeys =true, keyProperty = "id", keyColumn = "id")  
	int insertAccount(Account account);

	@Update("update account set name = #{1} where id = #{0}")
	int updateAccount(Integer id, String name);
}
