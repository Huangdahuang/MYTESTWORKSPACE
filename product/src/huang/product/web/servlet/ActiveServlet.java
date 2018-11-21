package huang.product.web.servlet;

import huang.product.exception.UserException;
import huang.product.service.UserService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActiveServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ������
		String activeCode = request.getParameter("activeCode");
		
		//
		UserService us = new UserService();
		try {
			us.activeUser(activeCode);
		} catch (UserException e) {
			e.printStackTrace();
			//���û���ʾʧ����Ϣ
			response.getWriter().write(e.getMessage());
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
