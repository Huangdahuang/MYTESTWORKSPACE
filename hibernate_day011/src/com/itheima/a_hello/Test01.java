package com.itheima.a_hello;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;


public class Test01 {
	@Test
	public void fun1() {
		//1����ȡ�����ļ�
		Configuration conf = new Configuration().configure();
		//2���������ô���Factory
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3�����ݻ�ò������ݿ��Session����
		Session session = sessionFactory.openSession();
		//4���������ݿ�
		User u = new User();
		u.setName("tom");
		u.setPassword("1234");
		session.save(u);
		//5���ر�
		session.close();
		sessionFactory.close();
	}
}
