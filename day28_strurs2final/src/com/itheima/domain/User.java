package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * User¿‡
 * @author Zhihong_Huang
 * 
 */
public class User implements Serializable {

	private Integer userID;
	private String userName;
	private String logonName;
	private String logonPwd;
	private String gender;
	private String birthday;
	private String education;
	private String telephone;
	private String hobby;
	private String path;
	private String filename;
	private String remark;

	public User() {
		super();
	}

	public User(Integer userID, String userName, String logonName,
			String logonPwd, String gender, String birthday, String education,
			String telephone, String hobby, String path, String filename,
			String remark) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.logonName = logonName;
		this.logonPwd = logonPwd;
		this.gender = gender;
		this.birthday = birthday;
		this.education = education;
		this.telephone = telephone;
		this.hobby = hobby;
		this.path = path;
		this.filename = filename;
		this.remark = remark;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLogonName() {
		return logonName;
	}

	public void setLogonName(String logonName) {
		this.logonName = logonName;
	}

	public String getLogonPwd() {
		return logonPwd;
	}

	public void setLogonPwd(String logonPwd) {
		this.logonPwd = logonPwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
