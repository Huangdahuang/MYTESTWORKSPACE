package com.itheima.service.impl;

import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao dao = new UserDaoImpl();
	
	public User findUserByUsername(String username) {
		return dao.selectUserByUsername(username);
	}

	public int register(User user) {
		return dao.addUser(user);
	}

}
