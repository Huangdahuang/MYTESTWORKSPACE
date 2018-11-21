package com.itheima.crm.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * CrmDepartment entity. @author MyEclipse Persistence Tools
 */

public class CrmDepartment implements java.io.Serializable {

	// Fields

	private String depId;
	private String depName;
	private Set crmPosts = new HashSet(0);

	// Constructors

	/** default constructor */
	public CrmDepartment() {
	}

	/** full constructor */
	public CrmDepartment(String depName, Set crmPosts) {
		this.depName = depName;
		this.crmPosts = crmPosts;
	}

	// Property accessors

	public String getDepId() {
		return this.depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return this.depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Set getCrmPosts() {
		return this.crmPosts;
	}

	public void setCrmPosts(Set crmPosts) {
		this.crmPosts = crmPosts;
	}

}