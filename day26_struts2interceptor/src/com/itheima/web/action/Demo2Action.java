package com.itheima.web.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Demo2Action extends ActionSupport {
	
	
	/**
	 * 用户登录的方法
	 * @return
	 */
	public String login(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", "test");
		return SUCCESS;
	}
	
	
	
	
	/**
	 * 无论是显示主页还是显示另一个页面都执行此方法，
	 * 返回成功
	 */
	public String execute(){
		return SUCCESS;
	}
}
