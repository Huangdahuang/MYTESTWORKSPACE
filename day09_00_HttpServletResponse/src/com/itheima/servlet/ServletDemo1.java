package com.itheima.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huangzhihong
 * */
public class ServletDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��������Ĭ�ϵı���ΪISO-8859-1,	��֧������ ��tomcat�涨
		
		/*//��֪������ʹ��UTF-8��������
		response.setCharacterEncoding("UTF-8");
		//���߿ͻ��ˣ������)ʹ��ʲô����
		response.setHeader("Content-type", "text/html;charset=UTF-8");*/
		
		//��֪������ʹ�á��ͻ���ʹ��UTF-8���뷽ʽ���������ϲ�
		response.setContentType("text/html;charset=UTF-8");
		
		
		PrintWriter out = response.getWriter();//�õ�һ���ַ������
		out.write("���123��");//��ͻ�����Ӧ�ı�����
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
