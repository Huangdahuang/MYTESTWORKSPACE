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
	 * 员工登录
	 * @return
	 */
	public String login() {
		CrmStaff findstaff = staffService.login(staff);
		if(findstaff != null) {
			ActionContext.getContext().getSession().put("loginStaff", findstaff);
			return "success";
		}
		
		//TODO 不成功
		this.addFieldError("","用户名或密码错误");
		//请求转发
		return "login";
	}
	/**
	 * 显示首页
	 * @return
	 */
	public String home() {
		return "home";
	}
}











