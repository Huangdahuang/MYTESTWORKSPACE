package com.itheima.c_inject.b_static_factory;

public class MyBeanFactory {
	/**
	 * ����ʵ��
	 * 
	 * @return UserService
	 */
	public static UserService createService() {
		return new UserServiceImpl();
	}
}
