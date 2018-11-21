package com.itheima.crm.domain;

import java.sql.Timestamp;

/**
 * CrmClasses entity. @author MyEclipse Persistence Tools
 */

public class CrmClasses implements java.io.Serializable {

	// Fields

	private String classId;
	private CrmCourseType crmCourseType;
	private String name;
	private Timestamp beginTime;
	private Timestamp endTime;
	private String status;
	private Integer totalCount;
	private Integer upgradeCount;
	private Integer changeCount;
	private Integer runoffCount;
	private String remark;
	private Timestamp uploadTime;
	private String uploadPath;
	private String uploadFilename;

	// Constructors

	/** default constructor */
	public CrmClasses() {
	}

	/** full constructor */
	public CrmClasses(CrmCourseType crmCourseType, String name,
			Timestamp beginTime, Timestamp endTime, String status,
			Integer totalCount, Integer upgradeCount, Integer changeCount,
			Integer runoffCount, String remark, Timestamp uploadTime,
			String uploadPath, String uploadFilename) {
		this.crmCourseType = crmCourseType;
		this.name = name;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.status = status;
		this.totalCount = totalCount;
		this.upgradeCount = upgradeCount;
		this.changeCount = changeCount;
		this.runoffCount = runoffCount;
		this.remark = remark;
		this.uploadTime = uploadTime;
		this.uploadPath = uploadPath;
		this.uploadFilename = uploadFilename;
	}

	// Property accessors

	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public CrmCourseType getCrmCourseType() {
		return this.crmCourseType;
	}

	public void setCrmCourseType(CrmCourseType crmCourseType) {
		this.crmCourseType = crmCourseType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getUpgradeCount() {
		return this.upgradeCount;
	}

	public void setUpgradeCount(Integer upgradeCount) {
		this.upgradeCount = upgradeCount;
	}

	public Integer getChangeCount() {
		return this.changeCount;
	}

	public void setChangeCount(Integer changeCount) {
		this.changeCount = changeCount;
	}

	public Integer getRunoffCount() {
		return this.runoffCount;
	}

	public void setRunoffCount(Integer runoffCount) {
		this.runoffCount = runoffCount;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getUploadPath() {
		return this.uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getUploadFilename() {
		return this.uploadFilename;
	}

	public void setUploadFilename(String uploadFilename) {
		this.uploadFilename = uploadFilename;
	}

}