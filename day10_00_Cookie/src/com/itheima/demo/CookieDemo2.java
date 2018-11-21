package com.itheima.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			System.out.println(cookies[i].getName());
			if("lastAccessTime".equals(cookies[i].getName())) {//�жϵ�ǰcookie��name�ǲ�����Ҫ��
				long l = Long.parseLong(cookies[i].getValue());//�������Ҫ�ģ����cookie
				out.write("���������ʱ��Ϊ��" + new Date(l).toLocaleString());
			}
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}