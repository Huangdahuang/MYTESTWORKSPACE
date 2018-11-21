package com.itheima.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.sevice.UserService;

public class AutoLoginMyFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 1、转化两个对象HttpServletRequest，HttpServletResponse
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		// System.out.println(uri);
		String path = req.getContextPath();
		path = uri.substring(path.length() + 1);
		// System.out.println(path);
		if (!("/login.jsp".equals(path) || "/servlet/loginServlet".equals(path))) {
			User user = (User) req.getSession().getAttribute("user");
			//如果用户没有登录过
			if (user == null) {
				// 2、处理业务
				// 得到cookie
				Cookie[] cookies = req.getCookies();
				// 从数组中找到想要的user对象的信息
				Cookie cookie = null;
				String username = "";
				String password = "";
				for (int i = 0; cookies != null && i < cookies.length; i++) {
					if ("user".equals(cookies[i].getName())) {
						String value = cookies[i].getValue();// tom&123
						String[] values = value.split("&");
						username = values[0];
						password = values[1];
					}
				}
				// 登录的操作
				UserService us = new UserService();
				User u = us.findUser(username, password);
				// 如果登录成功把用户信息存到session
				if (u != null) {
					req.getSession().setAttribute("user", u);
				}
			}

		}

		// 3、放行
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
