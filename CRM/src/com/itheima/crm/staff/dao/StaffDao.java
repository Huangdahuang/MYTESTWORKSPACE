package com.itheima.crm.staff.dao;

import com.itheima.crm.staff.domain.CrmStaff;

public interface StaffDao {
	/**
	 * ͨ���û����������ѯ
	 * @param loginName
	 * @param loginPwd
	 * @return CrmStaff
	 */
	public CrmStaff find(String loginName, String loginPwd);
}
