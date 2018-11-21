package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {
	/**
	 * 添加用户
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
	/**
	 * 查找用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findUser(User user) throws Exception;
}
