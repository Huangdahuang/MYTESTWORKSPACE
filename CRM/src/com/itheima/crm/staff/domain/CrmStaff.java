package com.itheima.crm.staff.domain;

import java.util.Date;

import com.itheima.crm.post.domain.CrmPost;

/**<h>员工类</h>
 * CREATE TABLE `crm_staff` (
	  <p>`staffId` VARCHAR(255) NOT NULL PRIMARY KEY,
	  <p>`loginName` VARCHAR(100) DEFAULT NULL,
	  <p>`loginPwd` VARCHAR(100) DEFAULT NULL,
	  <p>`staffName` VARCHAR(100) DEFAULT NULL,
	  <p>`gender` VARCHAR(20) DEFAULT NULL,
	  <p>`onDutyDate` DATETIME DEFAULT NULL,
	  <p>`postId` VARCHAR(255) DEFAULT NULL,
	  <p> CONSTRAINT FOREIGN KEY (`postId`) REFERENCES `crm_post` (`postId`)
	  <p>);
 * @author Zhihong_Huang
 *
 */
public class CrmStaff {
	private String staffId;
	private String loginName;
	private String loginPwd;
	private String staffName;
	private String gender;
	private Date onDutyDate;
	
	//一个员工属于多个职务
	private CrmPost post;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getOnDutyDate() {
		return onDutyDate;
	}

	public void setOnDutyDate(Date onDutyDate) {
		this.onDutyDate = onDutyDate;
	}

	public CrmPost getPost() {
		return post;
	}

	public void setPost(CrmPost post) {
		this.post = post;
	}
	
}























