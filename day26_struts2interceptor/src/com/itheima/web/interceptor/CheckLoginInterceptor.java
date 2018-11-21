package com.itheima.web.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 检查登录的拦截器,初级版本
 * @author zhy
 *
 */
public class CheckLoginInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		//1.获取HttpSession
		HttpSession session = ServletActionContext.getRequest().getSession();
		//2.获取session域中的登录标记
		Object obj = session.getAttribute("user");
		//3.判断是否有登录标记
		if(obj == null){
			//用户没有登录
			return "input";
		}
		//4.用户登录了，放行
		String rtValue = invocation.invoke();
		return rtValue;
	}

}
