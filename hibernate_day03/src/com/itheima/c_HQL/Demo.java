package com.itheima.c_HQL;

import org.hibernate.classic.Session;
import org.junit.Test;

import com.itheima.domain.Course;
import com.itheima.domain.Student;
import com.itheima.utils.H3Utils;

public class Demo {
	@Test
	
	public void fun1() {
		Session session = H3Utils.openSession();
		session.beginTransaction();
		//-------------------------
		
		//-------------------------
		session.getTransaction().commit();
		session.close();
	}
}
