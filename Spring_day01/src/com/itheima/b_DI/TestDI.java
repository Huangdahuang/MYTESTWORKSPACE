package com.itheima.b_DI;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestDI {
	@Test
	public void demo01() {
		// 从spring容器中获得
		String xmlPath = "com/itheima/d_DI/applicationContext.xml";

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath);

		BookService bookService = (BookService) applicationContext
				.getBean("bookServiceId");

		bookService.addBook();
	}

	@Test
	public void demo02() {
		// BeanFactory
		String xmlPath = "com/itheima/d_DI/applicationContext.xml";

		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
				xmlPath));

		BookService bookService = (BookService) beanFactory
				.getBean("bookServiceId");

		bookService.addBook();
	}
}
