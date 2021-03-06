package com.itheima.crm.staff.dao;

import com.itheima.crm.staff.domain.CrmStaff;

public interface StaffDao {
	/**
	 * 通过用户名和密码查询
	 * @param loginName
	 * @param loginPwd
	 * @return CrmStaff
	 */
	public CrmStaff find(String loginName, String loginPwd);
}
