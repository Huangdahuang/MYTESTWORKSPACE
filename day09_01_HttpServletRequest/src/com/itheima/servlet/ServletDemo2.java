package com.itheima.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ������Ϣͷ����Ϣ
		//test1(request);
		
		//���������Ϣ����ͷ��name
		//test2(request);
		
		Enumeration headers = request.getHeaders("accept-encoding");
		System.out.println(headers);
	}

	private void test2(HttpServletRequest request) {
		Enumeration names = request.getHeaderNames();
		while(names.hasMoreElements()) {
			String e = (String) names.nextElement();
			System.out.println(e + ":" + request.getHeader(e));
		}
	}

	private void test1(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		System.out.println(header);//Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; 
									//Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; 
										//.NET CLR 3.0.30729; InfoPath.2; .NET4.0C; .NET4.0E)
		if(header.toLowerCase().contains("msie")) {
			System.out.println("��ʹ�õ���IE�����");
		}else if(header.toLowerCase().contains("firefox")) {
			System.out.println("��ʹ�õ��ǻ�������");
		}else if(header.toLowerCase().contains("chrome")) {
			System.out.println("��ʹ�õ��ǹȸ������");
		}else  {
			System.out.println("��ʹ�õ������������");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
