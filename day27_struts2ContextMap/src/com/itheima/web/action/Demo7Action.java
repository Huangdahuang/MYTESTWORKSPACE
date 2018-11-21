package com.itheima.web.action;

import com.itheima.domain.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ����һ��С����
 * 
 * @author zhy
 * 
 */
public class Demo7Action extends ActionSupport implements ModelDriven<Customer> {

	// ����һ��ģ��,ע��,�����Լ�ʵ����
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
