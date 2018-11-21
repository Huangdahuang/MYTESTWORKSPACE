package com.itheima.dao;

import java.util.List;

import com.itheima.domain.User;

/**
 * �û�������س־ò�ӿ�
 * 
 * @author Zhihong_Huang
 * 
 */
public interface IUserDao {
	/**
	 * �����û������û������ѯ�û�
	 * @param logonName
	 * @param logonPwd
	 * @return User
	 */
	User selectUserByInfo(String logonName, String logonPwd);

	/**
	 * ����û�
	 * @param user
	 * @return int
	 */
	int addUser(User user);

	/**
	 * �����û���Ϣ
	 * @param user
	 * @return int 
	 */
	int updateUser(User user);

	/**
	 * �����û�Idɾ���û�
	 * @param userID
	 * @return int
	 */
	int deleteUser(Integer userID);

	/**
	 * �����û�Id��ѯ�û�
	 * @param userID
	 * @return User
	 */
	User selectUserById(Integer userID);

	/**
	 * ��ѯ�����û���Ϣ
	 * @return List
	 */
	List<User> selectAllUser();

	/**
	 * ����ָ��������ȡ�û���Ϣ
	 * ��������null��ʱ���������
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return List
	 */
	List<User> selectUserByCondition(String userName, String gender,
			String education, String isUpload);

}
