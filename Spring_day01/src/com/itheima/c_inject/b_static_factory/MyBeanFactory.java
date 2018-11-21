package com.itheima.c_inject.b_static_factory;

public class MyBeanFactory {
	/**
	 * ´´½¨ÊµÀý
	 * 
	 * @return UserService
	 */
	public static UserService createService() {
		return new UserServiceImpl();
	}
}
