package com.itheima.c_inject.c_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStaticFactory {
	@Test
	public void demo1() {
		// 自定义实例工厂
		MyBeanFactory myBeanFactory = new MyBeanFactory();
		// 通过工厂的实例获得对象
		UserService userService = myBeanFactory.createService();
		userService.addUser();
	}

	@Test
	public void demo2() {
		String xmlPath = "com/itheima/c_inject/c_factory/applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);
		UserService userService = applicationContext.getBean("userServiceId",
				UserService.class);
		userService.addUser();
	}
}
