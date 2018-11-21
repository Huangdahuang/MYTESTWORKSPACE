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
		//��ȡ������
		/**
		 * *** getParameter(name) ���ݱ���name���Ե�������ȡvalue���Ե�ֵ���� 
		 	*** getParameterValues��String name��רҵΪ��ѡ��ȡȡ�ṩ�ķ���
             getParameterNames() �õ����ύ������name�ķ��� 
		     *** getParameterMap �����ύ������ֵ�ķ���   //������ã��ǳ�ʵ��
			getInputStream  ���ֽ����ķ�ʽ�õ����б�����
		*/
		
		//test1(request);
		
		//test2(request);
		
		//test3(request);
		
		
		try {
			User u = new User();
			System.out.println("��װ����ǰ��" + u);
			
			BeanUtils.populate(u, request.getParameterMap());
			
			System.out.println("��װ���ݺ�" + u);
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
			System.out.println("��װ����ǰ��" + u);
			//��ȡ������
			Map<String,String[]> map = request.getParameterMap();
			
			for (Map.Entry<String, String[]> m : map.entrySet()) {
				String name = m.getKey();
				String[] value = m.getValue();
				
				//����һ������������
				PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
				
				//�õ�setter����
				Method setter = pd.getWriteMethod();
				if(value.length == 1) {
					setter.invoke(u, value[0]);//��һ��ֵ�ı�����ֵ 
				}else {
					setter.invoke(u, (Object)value);//����ѡ��ֵ
				}
			}
			
			System.out.println("��װ���ݺ�" + u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void test2(HttpServletRequest request) {
		//��ȡ������name������
		Enumeration names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = (String) names.nextElement();//�õ�ÿһ��name��
			System.out.print("");
			String[] values = request.getParameterValues(name);//�õ�ÿһ��name����ֵ
			for(int i = 0; i < values.length;i++) {
				System.out.println(name+"\t"+values[i]);
			}
		}
	}

	private void test1(HttpServletRequest request)
			throws UnsupportedEncodingException {
		//���߷�����ʹ�� ���ֱ��롣�����ʹ�õ���ʲô����ʲô
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
