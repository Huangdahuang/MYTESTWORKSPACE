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
		//获取请求消息头的信息
		//test1(request);
		
		//获得所有消息请求头的name
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
			System.out.println("您使用的是IE浏览器");
		}else if(header.toLowerCase().contains("firefox")) {
			System.out.println("您使用的是火狐浏览器");
		}else if(header.toLowerCase().contains("chrome")) {
			System.out.println("您使用的是谷歌浏览器");
		}else  {
			System.out.println("您使用的是其他浏览器");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
