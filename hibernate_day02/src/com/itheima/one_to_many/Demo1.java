package com.itheima.one_to_many;

import java.util.Set;

import org.hibernate.classic.Session;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.Order;
import com.itheima.domain.User;
import com.itheima.utils.H3Utils;
//����һ�Զ��ϵ
public class Demo1 { 
	@Test
	public void fun1() {
		Session session = H3Utils.openSession();
		session.beginTransaction();
		//=================================
		Customer c = new Customer();
		c.setName("tom");
		
		Order o1 = new Order();
		o1.setName("����");
		
		Order o2 = new Order();
		o2.setName("����");

		c.getOrders().add(o1);//ά����ϵ
		c.getOrders().add(o2);//ά����ϵ
		
		o1.setCustomer(c);//ά����ϵ
		o2.setCustomer(c);//ά����ϵ
		
		session.save(c);//�������
		session.save(o1);//�������
		session.save(o2);//�������
		
		//=================================
		session.getTransaction().commit();//�־�̬
		session.close();//����̬
	}
}








