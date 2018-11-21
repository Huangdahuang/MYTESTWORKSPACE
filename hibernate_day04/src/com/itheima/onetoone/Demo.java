package com.itheima.onetoone;

import org.hibernate.classic.Session;
import org.junit.Test;

import com.itheima.utils.H3Utils;

public class Demo {
	@Test
	public void fun() {
		Session session = H3Utils.openSession();
		session.beginTransaction();
		//---------------------------
		
		
		//---------------------------
		session.getTransaction().commit();
		session.close();
	}
}
