package com.huang.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Request extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * http 
		 * localhost 
		 * 8080 
		 * /HttpServletResponse 
		 * /servlet/request
		 * /HttpServletResponse/servlet/request 
		 * name=tom
		 */
		System.out.println(request.getScheme());
		System.out.println(request.getServerName());
		System.out.println(request.getServerPort());
		System.out.println(request.getContextPath());
		System.out.println(request.getServletPath());
		System.out.println(request.getRequestURI());
		System.out.println(request.getQueryString());
		System.out.println(request.getRemoteAddr());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
