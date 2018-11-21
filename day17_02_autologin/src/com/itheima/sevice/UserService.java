package com.itheima.sevice;

import java.sql.SQLException;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserService {
	UserDao ud = new UserDao();
	public User findUser(String username, String password) {
		
		try {
			return ud.findUser(username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
