package com.itheima.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserDaoImpl implements UserDao {
	// spring提供HibernateTemplate用于操作PO对象,类似于Hibernate Session对象
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(User user) {
		this.hibernateTemplate.save(user);
	}

}
