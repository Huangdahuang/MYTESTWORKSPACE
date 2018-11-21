package com.itheima.c_inject.b_static_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStaticFactory {
	@Test
	public void demo1() {
		UserService userService = MyBeanFactory.createService();
		userService.addUser();
	}

	@Test
	public void demo2() {
		String xmlPath = "com/itheima/c_inject/b_static_factory/applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);
		UserService userService = applicationContext.getBean("userServiceId",
				UserService.class);
		userService.addUser();
	}
}
