package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet({"/servlet/demo1","/servlet/demo11"})
public class ServletDemo1 extends HttpServlet {

/*	
	 * <servlet>
          <servlet-name>ServletDemo1</servlet-name>
          <servlet-class>com.itheima.servlet.ServletDemo1</servlet-class>
       </servlet>

       <servlet-mapping>
		    <servlet-name>ServletDemo1</servlet-name>
		    <url-pattern>/servlet/demo1</url-pattern>
  	   </servlet-mapping>
  	   */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         System.out.println("hello ServletDemo1");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
