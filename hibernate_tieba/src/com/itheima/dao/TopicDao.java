package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Topic;

public interface TopicDao {
	/**
	 * 保存帖子
	 * @param topic
	 */
	void save(Topic topic);
	/**
	 * 根据条件查询帖子列表
	 * @param key
	 * @return
	 */
	List<Topic> getAll(String  key);
}
