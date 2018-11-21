package com.itheima.web.action;

import com.itheima.domain.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 表单的一个小例子
 * 
 * @author zhy
 * 
 */
public class Demo7Action extends ActionSupport implements ModelDriven<Customer> {

	// 定义一个模型,注意,必须自己实例化
	private Customer customer = new Customer();

	public Customer getModel() {
		return customer;
	}

	public String save() {
		System.out.println(customer);
		return null;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
