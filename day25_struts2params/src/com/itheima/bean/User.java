package com.itheima.bean;

import java.io.Serializable;

/**
 * @author Zhihong-Huang
 *
 */
public class User implements Serializable{
	private String username;
	private int age;
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
	
	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + "]";
	}
	
}
