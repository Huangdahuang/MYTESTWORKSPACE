package com.itheima.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendDataServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�������ʽ
		String method = request.getMethod();
		System.out.println("1:����ʽ" + method);
		//����������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("2:���������" + username + " + " + password);
		//��Ӧ����JSON
			//3.1�ֶ���д
		String jsonData = "{\"message\":\"�ɹ���\"}";	
			//3.2������Ӧ��������
		//response.setContentType("text/html;charset=UTF-8");
			response.setContentType("applivation/json;charset=UTF-8");
			//3.3��������
		response.getWriter().print(jsonData);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
