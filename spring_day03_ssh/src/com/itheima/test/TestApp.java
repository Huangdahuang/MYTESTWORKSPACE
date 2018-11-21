package com.itheima.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.domain.User;
import com.itheima.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestApp {
	@Autowired
	private UserService userService;

	@Test
	public void demo1() {
		User user = new User();
		user.setUsername("tom");
		user.setPassword("123");
		user.setAge(23);

		userService.register(user);
	}
}
