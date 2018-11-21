package com.itheima.a_IoC;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoC {
	@Test
	public void demo01() {
		// ֮ǰ����
		UserService userService = new UserServiceImpl();
		userService.addUser();
	}

	@Test
	public void demo02() {
		// ��spring�����л��
		// 1���������
		String xmlPath = "com/itheima/a_IoC/applicationContext.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);
		// 2���������
		UserService userService = (UserService) applicationContext
				.getBean("userServiceId");
		userService.addUser();
	}
	@Test
	public void demo3() {
		
	}
}
