package com.itheima.c_inject.c_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStaticFactory {
	@Test
	public void demo1() {
		// �Զ���ʵ������
		MyBeanFactory myBeanFactory = new MyBeanFactory();
		// ͨ��������ʵ����ö���
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
