package com.itheima.crm.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * CrmPost entity. @author MyEclipse Persistence Tools
 */

public class CrmPost implements java.io.Serializable {

	// Fields

	private String postId;
	private CrmDepartment crmDepartment;
	private String postName;
	private Set crmStaffs = new HashSet(0);

	// Constructors

	/** default constructor */
	public CrmPost() {
	}

	/** full constructor */
	public CrmPost(CrmDepartment crmDepartment, String postName, Set crmStaffs) {
		this.crmDepartment = crmDepartment;
		this.postName = postName;
		this.crmStaffs = crmStaffs;
	}

	// Property accessors

	public String getPostId() {
		return this.postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public CrmDepartment getCrmDepartment() {
		return this.crmDepartment;
	}

	public void setCrmDepartment(CrmDepartment crmDepartment) {
		this.crmDepartment = crmDepartment;
	}

	public String getPostName() {
		return this.postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public Set getCrmStaffs() {
		return this.crmStaffs;
	}

	public void setCrmStaffs(Set crmStaffs) {
		this.crmStaffs = crmStaffs;
	}

}