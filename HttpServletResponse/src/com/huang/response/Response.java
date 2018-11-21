package com.huang.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Response extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("123你好hello!!!");
		/**
		 * 设置 重定向
		 * 
		 */
		response.setStatus(302); 
		response.setHeader("Location","http://www.itcast.cn");
		response.sendRedirect("http://www.itcast.cn");
		// response.setHeader("refresh", "2;url=http://www.baidu.com");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
