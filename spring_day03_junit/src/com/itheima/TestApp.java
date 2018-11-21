package com.itheima;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestApp {
	
	@Autowired //与Junit整合不需要再配置扫描
	private AccountService accountService;

	@Test
	public void demo1() {
		// String xmlPath = "applicationContext.xml";
		// ApplicationContext applicationContext = new
		// ClassPathXmlApplicationContext(xmlPath);
		//
		// AccountService accountService = (AccountService)
		// applicationContext.getBean("accountService");
		accountService.transfer("jack", "rose", 200);
	}
}
