package com.itheima.history;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.entity.Book;
import com.itheima.utils.DButil;

public class ShowBookDetail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// ��ʾͼ�����ϸ��Ϣ

		// ���id
		String id = request.getParameter("id");

		Book book = DButil.findBookId(id);
		out.write(book.toString());

		// �ѵ�ǰ����������idѪ�ؿͻ���
		String historyBookId = organized(id, request);
		Cookie ck = new Cookie("historyBookId", historyBookId);
		ck.setPath("/");
		ck.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(ck);
	}

	/**
	 * �ͻ��� showAll
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	private String organized(String id, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return id;
		}

		// ������û��name����historyBookId��cookies
		Cookie historyBook = null;
		for (int i = 0; i < cookies.length; i++) {
			if ("historyBookId".equals(cookies[i].getName())) {
				historyBook = cookies[i];
			}
		}
		// ���û��historyBookId��cookies���� id
		if (historyBook == null) {
			return id;
		}

		String value = historyBook.getValue();
		String[] values = value.split("-");
		LinkedList<String> list = new LinkedList<String>(Arrays.asList(values));

		if (list.size() < 3) {
			if (list.contains(id)) {
				list.remove(id);
			}
		} else {
			if (list.contains(id)) {
				list.remove(id);
			} else {
				list.removeLast();
			}
		}
		list.addFirst(id);

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (i > 0) {
				sb.append("-");
			}
			sb.append(list.get(i));
		}

		return sb.toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
