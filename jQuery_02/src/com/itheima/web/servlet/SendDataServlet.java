package com.itheima.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendDataServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得请求方式
		String method = request.getMethod();
		System.out.println("1:请求方式" + method);
		//获得请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("2:请求参数：" + username + " + " + password);
		//响应数据JSON
			//3.1手动编写
		String jsonData = "{\"message\":\"成功了\"}";	
			//3.2存在相应中文乱码
		//response.setContentType("text/html;charset=UTF-8");
			response.setContentType("applivation/json;charset=UTF-8");
			//3.3发送数据
		response.getWriter().print(jsonData);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
