package com.itheima.history;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.entity.Book;
import com.itheima.utils.DButil;

public class showAllBooksServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.write("本网站有以下好书：<br/>");
		Map<String, Book> books = DButil.findAllBooks();
		for (Map.Entry<String, Book> book : books.entrySet()) {
			out.write("<a href='" + request.getContextPath()
					+ "/servlet/showBookDetail?id=" + book.getKey()
					+ "' target='_blank'>" + book.getValue().getName()
					+ " </a><br/>");
		}

		out.write("<hr/>最近您浏览过的书有：<br/>");
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if ("historyBookId".equals(cookies[i].getName())) {
				String value = cookies[i].getValue();
				String[] ids = value.split("-");
				for (int j = 0; j < ids.length; j++) {
					Book book = DButil.findBookId(ids[j]);
					out.print("" + book.getName() + "<br/>");
				}
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
