package com.itheima.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * s:interator标签的 方法
 * @author Zhihong_Huang
 * 
 */
public class Demo4Action extends ActionSupport {
	private List<Student> students;
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
 
	public String findAll() {
		
		students = new ArrayList<Student>();
		students.add(new Student("aaa",23));
		students.add(new Student("bbb",24));
		students.add(new Student("acc",26));
		students.add(new Student("ddd",21));
		return SUCCESS;
	}
}
