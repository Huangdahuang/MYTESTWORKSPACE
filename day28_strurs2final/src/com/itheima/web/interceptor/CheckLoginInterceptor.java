package com.itheima.web.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 检查登录的拦截器
 * 
 * @author Zhihong_Huang
 * 
 */

public class CheckLoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 获取sesssion对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 在session域中招user对象
		User user = (User) session.getAttribute("user");
		// 没有就前往登录页面
		if (user == null) {
			return "login";
		}
		return invocation.invoke();

	}

}
