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
		User u = new User();//˲ʱ̬
		u.setName("tom");//˲ʱ̬
		u.setPassword("1234");//˲ʱ̬
		
		
		session.save(u);//�־�̬
		
		//=================================
		session.getTransaction().commit();//�־�̬
		session.close();//����̬
	}
}








