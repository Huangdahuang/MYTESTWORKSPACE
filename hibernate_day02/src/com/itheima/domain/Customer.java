package com.itheima.domain;

import java.util.HashSet;
import java.util.Set;

//1:N=Customer:Order
public class Customer {
	private Integer id;
	private String name;
	// 在1的一方表达多的一方的应用=》使用集合
	private Set<Order> orders = new HashSet<Order>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
