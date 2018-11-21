package com.itheima.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

}
