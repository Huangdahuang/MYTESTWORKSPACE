package com.itheima.a_state;

import org.hibernate.classic.Session;
import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.utils.H3Utils;

public class Demo1 { 
	@Test
	//
	public void fun1() {
		Session session = H3Utils.openSession();
		session.beginTransaction();
		//=================================
		User u = new User();//À≤ ±Ã¨
		u.setName("tom");//À≤ ±Ã¨
		u.setPassword("1234");//À≤ ±Ã¨
		
		
		session.save(u);//≥÷æ√Ã¨
		
		//=================================
		session.getTransaction().commit();//≥÷æ√Ã¨
		session.close();//”Œ¿ÎÃ¨
	}
}








