package com.itheima.dao;

import com.itheima.domain.User;

/**
 * 用户相关操作的持久层接口
 * @author Zhihong-Huang
 *
 */
public interface UserDao {

	/**
	 * 根据用户名称查找用户
	 * @param username
	 * @return
	 */
	User selectUserByUsername(String username);

	/**保存用户信息
	 * @param user
	 * @return
	 */
	int addUser(User user);

}
