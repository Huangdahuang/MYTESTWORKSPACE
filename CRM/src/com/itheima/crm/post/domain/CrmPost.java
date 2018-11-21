package com.itheima.crm.post.domain;

import java.util.HashSet;
import java.util.Set;

import com.itheima.crm.department.domain.CrmDepartment;
import com.itheima.crm.staff.domain.CrmStaff;

/**
 * <h>ְ����</h>
 * <p>CREATE TABLE `crm_post` (
	  <p>`postId` VARCHAR(255) NOT NULL PRIMARY KEY,
	  <p>`postName` VARCHAR(100) DEFAULT NULL,
	  <p>`depId` VARCHAR(255) DEFAULT NULL,
	  <p> CONSTRAINT FOREIGN KEY (`depId`) REFERENCES `crm_department` (`depId`)
	  <p>);
 * @author Zhihong_Huang
 *
 */
public class CrmPost {
	private String postId;
	private String postName;
	
	//���һ�����ְ������һ�����ţ�
	private CrmDepartment department;
	
	//һ��ְ���Ӧ���Ա��
	private Set<CrmStaff> staffSet = new HashSet<CrmStaff>();

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public CrmDepartment getDepartment() {
		return department;
	}

	public void setDepartment(CrmDepartment department) {
		this.department = department;
	}

	public Set<CrmStaff> getStaffSet() {
		return staffSet;
	}

	public void setStaffSet(Set<CrmStaff> staffSet) {
		this.staffSet = staffSet;
	}
	
}













