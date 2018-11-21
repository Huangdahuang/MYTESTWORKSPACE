package com.itheima.crm.staff.service.impl;

import com.itheima.crm.staff.dao.StaffDao;
import com.itheima.crm.staff.domain.CrmStaff;
import com.itheima.crm.staff.service.StaffService;

public class StaffServiceImpl implements StaffService {
	private StaffDao staffDao;

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	@Override
	public CrmStaff login(CrmStaff staff) {
		return staffDao.find(staff.getLoginName(), staff.getLoginPwd());
	}

}
