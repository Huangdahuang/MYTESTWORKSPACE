package com.itheima.web.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itheima.dao.TopicDao;
import com.itheima.dao.TopicDaoImpl;
import com.itheima.domain.Topic;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TopicAction extends ActionSupport {
	private Topic topic;
	private String key;
	private TopicDao ud = new TopicDaoImpl();
	
	/**
	 * 查询
	 * @return
	 */
	public String list() {
		//调用dao获得帖子列表
		List<Topic> list = ud.getAll(key);
		//将帖子列表放入ActionContext中
		ActionContext context = ActionContext.getContext();
		context.put("list", list);
		return "list";
	}
	
	
	/**
	 * 发帖
	 * @return
	 */
	public String add() {
		//1 ip 
		topic.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		//2  创建/回帖时间
		topic.setCreateDate(new Date());
		topic.setLastReplyDate(topic.getCreateDate());
		//3 保存
		ud.save(topic);
		return "toList";
	}
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}
}
