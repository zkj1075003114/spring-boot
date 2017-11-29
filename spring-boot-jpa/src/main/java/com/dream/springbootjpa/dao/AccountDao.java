package com.dream.springbootjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dream.springbootjpa.model.Account;


public interface AccountDao extends JpaRepository<Account,Integer>{

}
