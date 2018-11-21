package com.itheima.a_proxy.b_cglib;

import org.junit.Test;

public class Testcglib {
	@Test
	public void demo1() {
		UserServiceImpl userService = MyBeanFactory.createService();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
}
