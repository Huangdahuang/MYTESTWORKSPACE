package com.itheima.servlet;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.entity.User;

public class ServletDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取表单数据
		/**
		 * *** getParameter(name) 根据表单中name属性的名，获取value属性的值方法 
		 	*** getParameterValues（String name）专业为复选框取取提供的方法
             getParameterNames() 得到表单提交的所有name的方法 
		     *** getParameterMap 到表单提交的所有值的方法   //做框架用，非常实用
			getInputStream  以字节流的方式得到所有表单数据
		*/
		
		//test1(request);
		
		//test2(request);
		
		//test3(request);
		
		
		try {
			User u = new User();
			System.out.println("封装数据前：" + u);
			
			BeanUtils.populate(u, request.getParameterMap());
			
			System.out.println("封装数据后：" + u);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void test3(HttpServletRequest request) {
		try {
			User u = new User();
			System.out.println("封装数据前：" + u);
			//获取表单数据
			Map<String,String[]> map = request.getParameterMap();
			
			for (Map.Entry<String, String[]> m : map.entrySet()) {
				String name = m.getKey();
				String[] value = m.getValue();
				
				//创建一个属性描述器
				PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
				
				//得到setter属性
				Method setter = pd.getWriteMethod();
				if(value.length == 1) {
					setter.invoke(u, value[0]);//给一个值的变量赋值 
				}else {
					setter.invoke(u, (Object)value);//给复选框赋值
				}
			}
			
			System.out.println("封装数据后：" + u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void test2(HttpServletRequest request) {
		//获取表单所有name的名字
		Enumeration names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = (String) names.nextElement();//得到每一个name名
			System.out.print("");
			String[] values = request.getParameterValues(name);//得到每一个name名的值
			for(int i = 0; i < values.length;i++) {
				System.out.println(name+"\t"+values[i]);
			}
		}
	}

	private void test1(HttpServletRequest request)
			throws UnsupportedEncodingException {
		//告诉服务器使用 何种编码。浏览器使用的是什么则是什么
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String[] hobbys = request.getParameterValues("hobby");
		String city = request.getParameter("city");
		
		System.out.println(username);
		System.out.println(pwd);
		System.out.println(sex);
		
		for(int i = 0; hobbys != null && i <= hobbys.length-1;i++) {
			System.out.print(hobbys[i] + "\t");
		}
		System.out.println("");
		System.out.println(city);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
