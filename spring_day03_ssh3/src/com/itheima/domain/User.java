package com.itheima.domain;

/**
 * CREATE TABLE t_user(
 * <p>
 * id INT PRIMARY KEY AUTO_INCREMENT,
 * <p>
 * username VARCHAR(50),
 * <p>
 * PASSWORD VARCHAR(32),
 * <p>
 * age INT
 * <p>
 * );
 * 
 * @author Zhihong_Huang
 * 
 */
public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
