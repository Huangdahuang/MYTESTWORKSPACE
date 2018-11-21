package com.itheima.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserDaoImpl implements UserDao {
	// spring�ṩHibernateTemplate���ڲ���PO����,������Hibernate Session����
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(User user) {
		this.hibernateTemplate.save(user);
	}

}
