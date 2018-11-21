package com.itheima.web.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * ����¼��������
 * 
 * @author Zhihong_Huang
 * 
 */

public class CheckLoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// ��ȡsesssion����
		HttpSession session = ServletActionContext.getRequest().getSession();
		// ��session������user����
		User user = (User) session.getAttribute("user");
		// û�о�ǰ����¼ҳ��
		if (user == null) {
			return "login";
		}
		return invocation.invoke();

	}

}
