package com.itheima.web.action;

import com.itheima.bean.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Zhihong-Huang
 *
 */
public class UserAction extends ActionSupport {
	private User user;
	
	public String addUser() {
		System.out.println(user);
		return null;
	}
  
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
