package com.itheima.service;

import com.itheima.domain.User;

/**
 * �û���ز�����ҵ���ӿ�
 * @author Zhihong-Huang
 *
 */
public interface IUserService {
	/**
	 * �ж��û��Ƿ���ڣ������û���
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);
	
	/**
	 * �û�ע��
	 * @param user
	 */
	int register(User user);
}
