package com.itheima.c_inject.c_factory;

public class MyBeanFactory {
	/**
	 * ʵ������
	 * 
	 * @return UserService
	 */
	public UserService createService() {
		return new UserServiceImpl();
	}
}
