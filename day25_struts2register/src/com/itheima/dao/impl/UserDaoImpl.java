package com.itheima.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.DBCPUtil;

/**
 * @author Zhihong-Huang
 * 
 */
public class UserDaoImpl implements UserDao {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	public User selectUserByUsername(String username) {
		try {
			return qr.query("select * from user where username=?",
					new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int addUser(User user) {
		try {
			return qr.update("insert into user(username,password,birthday,hobby,married)values(?,?,?,?,?)",
					user.getUsername(),user.getPassword(),user.getBirthday(),user.getHobby(),user.isMarried());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
