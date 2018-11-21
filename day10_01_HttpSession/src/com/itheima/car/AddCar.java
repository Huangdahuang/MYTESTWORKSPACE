package com.itheima.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.entity.Book;
import com.itheima.utils.DButil;

public class AddCar extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ID�õ���
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		Book book = DButil.findBookId(id);
		out.write("����ɹ�");
		// ��session��ȡ��list(���ﳵ)
		HttpSession session = request.getSession();

		List<Book> list = (List<Book>) session.getAttribute("car");

		if (list == null) {
			list = new ArrayList<Book>();
		}
		list.add(book);

		session.setAttribute("car", list);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
