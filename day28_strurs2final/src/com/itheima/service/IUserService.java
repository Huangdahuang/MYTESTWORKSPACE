package com.itheima.service;

import java.util.List;

import com.itheima.domain.User;

/**
 * �û����������ҵ��ӿ�
 * 
 * @author Zhihong_Huang
 * 
 */
public interface IUserService {
	/**
	 * �û���¼
	 * 
	 * @param logonName
	 * @param logonPwd
	 * @return User
	 */
	User login(String logonName, String logonPwd);

	/**
	 * ����û�
	 * 
	 * @param user
	 * @return int
	 */
	int saveUser(User user);

	/**
	 * �޸��û�
	 * 
	 * @param user
	 * @return int
	 */
	int modifyUser(User user);

	/**
	 * �����û�idɾ���û�
	 * 
	 * @param userID
	 * @return int
	 */
	int removeUser(Integer userID);

	/**
	 * �����û�id����ȡ�û���Ϣ
	 * 
	 * @param userID
	 * @return User
	 */
	User findUserByID(Integer userID);

	/**
	 * ��ѯ�����û�
	 * 
	 * @return List<User>
	 */
	List<User> findAllUser();

	/**
	 * ������������
	 * 
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUplod
	 * @return List<User>
	 */
	List<User> findUserByCondition(String userName, String gender,
			String education, String isUpload);
}
