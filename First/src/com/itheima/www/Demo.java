package com.itheima.www;

public class Demo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student s = new student();
		System.out.println(s);
		s.name = "ÕÅÈı";
		s.age = 23;
		s.gender = "ÄĞ";
		
	}
	
}

class student {
	String name;
	int age;
	String gender;
	
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public student(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
}
