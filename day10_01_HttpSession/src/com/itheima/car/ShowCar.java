package com.itheima.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.entity.Book;

public class ShowCar extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// 得到Session
		PrintWriter out = response.getWriter();
		out.print("购物测有以下书 : <br/>");
		List<Book> books = (List<Book>) request.getSession()
				.getAttribute("car");
		if (books == null) {
			out.print("购物车是空的");
			response.setHeader("refresh", "2;url=" + request.getContextPath()
					+ "/servlet/showAllBooksServlet");
			return;
			// response.sendRedirect(request.getContextPath()+"/servlet/showAllBooksServlet");
		}
		for (Book book : books) {
			out.write(book.getName() + "<br/>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
