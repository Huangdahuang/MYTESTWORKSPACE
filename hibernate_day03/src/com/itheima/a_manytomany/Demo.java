package com.itheima.a_manytomany;

import org.hibernate.classic.Session;
import org.junit.Test;

import com.itheima.domain.Course;
import com.itheima.domain.Student;
import com.itheima.utils.H3Utils;

public class Demo {
	@Test
	/**
	 * 保存学生=》通过学生保存课程，由学生维护外键
	 * 学生端：inverse=false
	 * 		  cascade=save-update
	 * 课程端：inverse=true
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
		//设置了save-update，因此只需要管student端就可以
		Course c1 = new Course();
		c1.setName("struts2");
		
		Course c2 = new Course();
		c2.setName("hibernate");
		
		Course c3 = new Course();
		c3.setName("Spring");
		//维护关系，级联保存
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
