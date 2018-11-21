package com.itheima.a_log4j;

import org.hibernate.classic.Session;
import org.junit.Test;

import com.itheima.utils.H3Utils;


public class Demo {
	@Test
	public void fun() {
		Session session = H3Utils.openSession();
		session.beginTransaction();
		//--------------------------
		
		
		
		
		
		//--------------------------
		session.getTransaction().commit();
		session.close();
	}
}
