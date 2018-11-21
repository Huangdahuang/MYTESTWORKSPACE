package com.itheima.crm.domain;

import java.sql.Timestamp;

/**
 * CrmStaff entity. @author MyEclipse Persistence Tools
 */

public class CrmStaff implements java.io.Serializable {

	// Fields

	private String staffId;
	private CrmPost crmPost;
	private String loginName;
	private String loginPwd;
	private String staffName;
	private String gender;
	private Timestamp onDutyDate;

	// Constructors

	/** default constructor */
	public CrmStaff() {
	}

	/** full constructor */
	public CrmStaff(CrmPost crmPost, String loginName, String loginPwd,
			String staffName, String gender, Timestamp onDutyDate) {
		this.crmPost = crmPost;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.staffName = staffName;
		this.gender = gender;
		this.onDutyDate = onDutyDate;
	}

	// Property accessors

	public String getStaffId() {
		return this.staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public CrmPost getCrmPost() {
		return this.crmPost;
	}

	public void setCrmPost(CrmPost crmPost) {
		this.crmPost = crmPost;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getOnDutyDate() {
		return this.onDutyDate;
	}

	public void setOnDutyDate(Timestamp onDutyDate) {
		this.onDutyDate = onDutyDate;
	}

}