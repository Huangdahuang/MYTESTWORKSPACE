package com.itheima.web.action;

import com.opensymphony.xwork2.Action;
/**
 * 创建动作类的第二种方式：
 *          创建一个普通类，实现Action接口
 * @author Zhihong-Huang
 *
 */
public class Demo2Action implements Action {
	/**
	 * Action接口中的 常量：
	 *   
	 */
	public String execute() throws Exception {
		return SUCCESS;
	}

}
