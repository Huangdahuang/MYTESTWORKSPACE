package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.IUserService;

/**
 * @author Zhihong-Huang
 *
 */
public class UserSerciveImpl implements IUserService {
	private UserDao dao = new UserDaoImpl();
	public User findUserByUsername(String username) {

		return dao.selectUserByUsername(username);
	}

	public int register(User user) {

		return dao.addUser(user);
	}

}
