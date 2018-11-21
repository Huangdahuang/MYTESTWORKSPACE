package com.itheima.web.action;

import com.itheima.domain.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport implements
		ModelDriven<Student> {

	private Student student = new Student();

	public Student getModel() {
		return student;
	}

	public String addStudent() {
		return SUCCESS;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
