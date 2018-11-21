package com.itheima.crm.staff.web.action;

import com.itheima.crm.staff.domain.CrmStaff;
import com.itheima.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff>{

	private CrmStaff staff = new CrmStaff();
	@Override
	public CrmStaff getModel() {
		return staff;
	}
	
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	/////////////////////////////////////
	/**
	 * Ա����¼
	 * @return
	 */
	public String login() {
		CrmStaff findstaff = staffService.login(staff);
		if(findstaff != null) {
			ActionContext.getContext().getSession().put("loginStaff", findstaff);
			return "success";
		}
		
		//TODO ���ɹ�
		this.addFieldError("","�û������������");
		//����ת��
		return "login";
	}
	/**
	 * ��ʾ��ҳ
	 * @return
	 */
	public String home() {
		return "home";
	}
}











