package com.dream.springbootjdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dream.springbootjdbc.dao.IUserDao;
import com.dream.springbootjdbc.modle.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public User getUserByName(String name) {
		String sql = "select * from t_user where username = ?";
		List<User> list = jdbcTemplate.query(sql,  new Object[]{name},new UserRowMapper());
		return list.get(0);
	}

	class UserRowMapper implements RowMapper<User> {
		
		  @Override
		    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		        User user = new User();
		        user.setId(rs.getInt("id"));
		        user.setUsername(rs.getString("username"));
		        user.setPasswd(rs.getString("passwd"));

		        return user;
		    }
	}
}
