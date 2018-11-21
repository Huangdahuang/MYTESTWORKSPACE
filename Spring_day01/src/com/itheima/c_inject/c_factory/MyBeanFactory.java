package com.itheima.c_inject.c_factory;

public class MyBeanFactory {
	/**
	 * ÊµÀý¹¤³§
	 * 
	 * @return UserService
	 */
	public UserService createService() {
		return new UserServiceImpl();
	}
}
