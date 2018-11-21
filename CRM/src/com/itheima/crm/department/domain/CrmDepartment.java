package com.itheima.crm.department.domain;

import java.util.HashSet;
import java.util.Set;

import com.itheima.crm.post.domain.CrmPost;

/**
 * <h>������</h>
 * <p>CREATE TABLE `crm_department` (
 * <p>`depId` VARCHAR(255) NOT NULL PRIMARY KEY,
 * <p>`depName` VARCHAR(50) DEFAULT NULL
 * <p>);
 * @prama depId   ����ID
 * 		  <p>depName   ��������
 * @author Zhihong_Huang
 * 
 */
public class CrmDepartment {
	private String depId;
	private String depName; //��������
	//һ�����Ŷ�Ӧ���ְ��,ѡ�񼯺�
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









