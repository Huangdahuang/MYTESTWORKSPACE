package com.itheima.domain;

import java.io.Serializable;

/**
 * 只是为了演示值栈的存取
 * 
 * @author Zhihong_Huang
 * 
 */
public class Student implements Serializable {

	private String name;
	private int age;

	public Student() {

	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
