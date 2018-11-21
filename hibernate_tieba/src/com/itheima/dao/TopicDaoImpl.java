package com.itheima.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.itheima.domain.Topic;
import com.itheima.utils.H3Utils;

public class TopicDaoImpl implements TopicDao {

	public void save(Topic topic) {
		Session session = H3Utils.getCurrentSession();
		session.save(topic);
	}

	public List<Topic> getAll(String key) {
		// 获得session
		Session session = H3Utils.getCurrentSession();
		// 创建query对象
		Query query = session.createQuery("from Topic where title like :key");
		// 设置参数
		if (key != null && !"".equals(key.trim())) {
			query.setString("key", "%" + key + "%");
		} else {
			query.setString("key", "%");
		}
		// 执行list
		return query.list();
	}

}
