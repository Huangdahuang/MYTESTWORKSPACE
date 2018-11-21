package com.itheima.a_IoC;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoC {
	@Test
	public void demo01() {
		// 之前开发
		UserService userService = new UserServiceImpl();
		userService.addUser();
	}

	@Test
	public void demo02() {
		// 从spring容器中获得
		// 1：获得容器
		String xmlPath = "com/itheima/a_IoC/applicationContext.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);
		// 2：获得内容
		UserService userService = (UserService) applicationContext
				.getBean("userServiceId");
		userService.addUser();
	}
	@Test
	public void demo3() {
		
	}
}
