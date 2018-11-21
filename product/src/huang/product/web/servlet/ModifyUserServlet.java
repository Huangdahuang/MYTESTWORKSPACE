package huang.product.web.servlet;

import huang.product.domain.User;
import huang.product.service.UserService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public class ModifyUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			UserService us = new UserService();
			us.modifyUser(user);
			
			//request.getRequestDispatcher("/modifyUserInfoSuccess.jsp").forward(request, response);
			request.getSession().invalidate();//×¢Ïú
			response.sendRedirect(request.getContextPath()+"/modifyUserInfoSuccess.jsp");
			
		} catch (Exception e) {
			response.getWriter().write(e.getMessage());
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
