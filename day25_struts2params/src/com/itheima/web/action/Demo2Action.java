package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 动态封装，第一种情况
 * 			数据模型与动作类写在一起
 * @author Zhihong-Huang
 * 
 */
public class Demo2Action extends ActionSupport {
	
	private String username;
	private int age;
	
	public String addUser() {
		System.out.println(username+"..."+ age);
		return null;// 不返回任何结果视图
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
