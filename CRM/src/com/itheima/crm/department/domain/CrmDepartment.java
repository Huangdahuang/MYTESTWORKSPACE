package com.itheima.crm.department.domain;

import java.util.HashSet;
import java.util.Set;

import com.itheima.crm.post.domain.CrmPost;

/**
 * <h>部门类</h>
 * <p>CREATE TABLE `crm_department` (
 * <p>`depId` VARCHAR(255) NOT NULL PRIMARY KEY,
 * <p>`depName` VARCHAR(50) DEFAULT NULL
 * <p>);
 * @prama depId   部门ID
 * 		  <p>depName   部门名称
 * @author Zhihong_Huang
 * 
 */
public class CrmDepartment {
	private String depId;
	private String depName; //部门名称
	//一个部门对应多个职务,选择集合
	private Set<CrmPost> postSet = new HashSet<CrmPost>();
	
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public Set<CrmPost> getPostSet() {
		return postSet;
	}
	public void setPostSet(Set<CrmPost> postSet) {
		this.postSet = postSet;
	}
}









