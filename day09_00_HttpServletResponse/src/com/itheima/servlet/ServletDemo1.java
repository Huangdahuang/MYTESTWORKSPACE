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
		//服务器中默认的编码为ISO-8859-1,	不支持中文 ，tomcat规定
		
		/*//告知服务器使用UTF-8解析数据
		response.setCharacterEncoding("UTF-8");
		//告诉客户端（浏览器)使用什么编码
		response.setHeader("Content-type", "text/html;charset=UTF-8");*/
		
		//告知服务器使用、客户端使用UTF-8编码方式，将上述合并
		response.setContentType("text/html;charset=UTF-8");
		
		
		PrintWriter out = response.getWriter();//得到一个字符输出流
		out.write("你好123！");//向客户端相应文本内容
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
