package com.ithiema.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Zhihong_Huang
 * 
 */
public class Demo1Action extends ActionSupport {
	public String execute() {
		String value = getText("key");
		System.out.println(value);
		return SUCCESS;
	}
}
