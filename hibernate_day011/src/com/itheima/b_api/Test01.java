package com.itheima.b_api;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.itheima.a_hello.User;


public class Test01 {
	@Test
	public void fun1() {
		//1：读取配置文件
		Configuration conf = new Configuration().configure();
		//2：根据配置创建SessionFactory
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//3：根据获得操作数据库的Session对象
		Session session = sessionFactory.openSession();
		//4：操作数据库
		User u = new User();
		u.setName("tom");
		u.setPassword("1234");
		session.save(u);
		//5：关闭
		session.close();
		sessionFactory.close();
	}
}
