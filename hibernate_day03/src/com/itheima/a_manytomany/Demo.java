package com.itheima.a_manytomany;

import org.hibernate.classic.Session;
import org.junit.Test;

import com.itheima.domain.Course;
import com.itheima.domain.Student;
import com.itheima.utils.H3Utils;

public class Demo {
	@Test
	/**
	 * ����ѧ��=��ͨ��ѧ������γ̣���ѧ��ά�����
	 * ѧ���ˣ�inverse=false
	 * 		  cascade=save-update
	 * �γ̶ˣ�inverse=true
	 * 		 cascade=save-update
	 */
	public void fun1() {
		Session session = H3Utils.openSession();
		session.beginTransaction();
		//-------------------------
		Student stu1 = new Student();
		stu1.setName("tom");
		
		Student stu2 = new Student();
		stu2.setName("jerry");
		//������save-update�����ֻ��Ҫ��student�˾Ϳ���
		Course c1 = new Course();
		c1.setName("struts2");
		
		Course c2 = new Course();
		c2.setName("hibernate");
		
		Course c3 = new Course();
		c3.setName("Spring");
		//ά����ϵ����������
		stu1.getCourses().add(c1);
		stu1.getCourses().add(c2);
		
		stu2.getCourses().add(c2);
		stu2.getCourses().add(c3);
		
		session.save(stu1);
		session.save(stu2);
		
		//-------------------------
		session.getTransaction().commit();
		session.close();
	}
}
