package com.itheima.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获得客户端保存的最后访问时间
		Cookie[] cookies = request.getCookies();//获得客户端的所有cookie
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			System.out.println(cookies[i].getName());
			if("lastAccessTime".equals(cookies[i].getName())) {//判断当前cookie的name是不是想要的
				long l = Long.parseLong(cookies[i].getValue());//如果是想要的，则把cookie
				out.write("你的最后访问时间为：" + new Date(l).toLocaleString());
			}
			
		}
		
		//创建Cookie
		Cookie ck = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
		//设置COOKIE的有效时间，S
		ck.setMaxAge(60*5);
		//并把信息写回客户端
		response.addCookie(ck);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
