package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String str = "aaaaa";
		
		System.out.println("A:�������");
		System.out.println("B:�Ұ첻�ˣ����ҿ������˰����");
		
		//���Ǳ���������ӵ�request������
		request.setAttribute("s", str);
		//������ת����demo6��
		//request.getRequestDispatcher("/servlet/demo6").forward(request, response);
		//ע������ת��������ת������Ӧ��
		//request.getRequestDispatcher("http://www.baidu.com").forward(request, response);
		//ʹ���ض���
		//response.sendRedirect(request.getContextPath()+"/servlet/demo6");
		//������ת������Ӧ��
		//response.sendRedirect("http://www .baidu.com");
		System.out.println("B:�°�����");
		
		//�������
		request.getRequestDispatcher("/servlet/demo6").include(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
