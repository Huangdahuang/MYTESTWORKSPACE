package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo1 implements Servlet {
	//Servlet�������ڵķ���
	//��Servlet��һ�α�����ʱ������
	//ʵ����  
	public ServletDemo1() {
		System.out.println("*********ServletDemo1ִ����*********");
	}
	//Servlet�������ڵķ���
	//��ʼ��   //��Servlet��һ�α�����ʱ������
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("*********initִ����*********");

	}
	//Servlet�������ڵķ���
	//����  ÿ�ζ�������
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		//System.out.println("hello servlet");
		System.out.println("*********serviceִ����*********");
	}
	//Servlet�������ڵķ���
	//����
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("*********destroyִ����*********");
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
