package com.itheima.crm.coursetype.domain;

import java.util.HashSet;
import java.util.Set;

import com.itheima.crm.classes.domain.CrmClasses;

/**
 * CREATE TABLE `crm_course_type` (
  `courseTypeId` VARCHAR(255) NOT NULL PRIMARY KEY,
  `courseCost` DOUBLE DEFAULT NULL,
  `total` INT(11) DEFAULT NULL,
  `courseName` VARCHAR(500) DEFAULT NULL,
  `remark` VARCHAR(5000) DEFAULT NULL
);
 * @author Zhihong_Huang
 *
 */
public class CrmCourseType {
	private String courseTypeId;
	private String courseCost;
	private int total;
	private String courseName;
	private String remark;
	
	//一个课程对应多个班级
	private Set<CrmClasses> classesSet = new HashSet<CrmClasses>();

	public String getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(String courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	public String getCourseCost() {
		return courseCost;
	}

	public void setCourseCost(String courseCost) {
		this.courseCost = courseCost;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<CrmClasses> getClassesSet() {
		return classesSet;
	}

	public void setClassesSet(Set<CrmClasses> classesSet) {
		this.classesSet = classesSet;
	}

	
	
}
