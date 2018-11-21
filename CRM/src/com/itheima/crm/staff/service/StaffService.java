package com.itheima.crm.staff.service;

import com.itheima.crm.staff.domain.CrmStaff;

public interface StaffService {
	/**
	 * 通过用户名、密码登录
	 * @param loginName
	 * @param loginPwd
	 * @return CrmStaff
	 */
	public CrmStaff login(CrmStaff staff);
}
