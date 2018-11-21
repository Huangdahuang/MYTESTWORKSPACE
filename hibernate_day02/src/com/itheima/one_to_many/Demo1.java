package com.itheima.one_to_many;

import java.util.Set;

import org.hibernate.classic.Session;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.Order;
import com.itheima.domain.User;
import com.itheima.utils.H3Utils;
//测试一对多关系
public class Demo1 { 
	@Test
	public void fun1() {
		Session session = H3Utils.openSession();
		session.beginTransaction();
		//=================================
		Customer c = new Customer();
		c.setName("tom");
		
		Order o1 = new Order();
		o1.setName("肥皂");
		
		Order o2 = new Order();
		o2.setName("蜡烛");

		c.getOrders().add(o1);//维护关系
		c.getOrders().add(o2);//维护关系
		
		o1.setCustomer(c);//维护关系
		o2.setCustomer(c);//维护关系
		
		session.save(c);//保存对象
		session.save(o1);//保存对象
		session.save(o2);//保存对象
		
		//=================================
		session.getTransaction().commit();//持久态
		session.close();//游离态
	}
}








