package com.itheima.dao;

import com.itheima.domain.User;

/**
 * �û���ز����ĳ־ò�ӿ�
 * @author Zhihong-Huang
 *
 */
public interface UserDao {

	/**
	 * �����û����Ʋ����û�
	 * @param username
	 * @return
	 */
	User selectUserByUsername(String username);

	/**�����û���Ϣ
	 * @param user
	 * @return
	 */
	int addUser(User user);

}
