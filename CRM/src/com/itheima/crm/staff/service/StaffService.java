package com.itheima.crm.staff.service;

import com.itheima.crm.staff.domain.CrmStaff;

public interface StaffService {
	/**
	 * ͨ���û����������¼
	 * @param loginName
	 * @param loginPwd
	 * @return CrmStaff
	 */
	public CrmStaff login(CrmStaff staff);
}
