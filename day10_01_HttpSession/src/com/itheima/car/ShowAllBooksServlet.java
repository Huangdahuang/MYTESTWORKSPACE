package com.itheima.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.entity.Book;
import com.itheima.utils.DButil;

public class ShowAllBooksServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("本网站有以下好书：<br/>");
		Map<String, Book> books = DButil.findAllBooks();
		for (Map.Entry<String, Book> book : books.entrySet()) {
			out.print("<a href='" + request.getContextPath()
					+ "/servlet/addCar?id=" + book.getKey() + "' target='_blank'>"
					+ book.getValue().getName() + "</a></br>");
		}
		
		out.print("<hr> <a href='"+request.getContextPath()+"/servlet/showCar'>查看购物车</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
