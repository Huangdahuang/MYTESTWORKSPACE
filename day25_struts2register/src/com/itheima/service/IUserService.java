package com.itheima.service;

import com.itheima.domain.User;

/**
 * 用户相关操作的业务层接口
 * @author Zhihong-Huang
 *
 */
public interface IUserService {
	/**
	 * 判断用户是否存在，根据用户名
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);
	
	/**
	 * 用户注册
	 * @param user
	 */
	int register(User user);
}
