package com.itheima.dao;

import java.util.List;

import com.itheima.domain.User;

/**
 * 用户操作相关持久层接口
 * 
 * @author Zhihong_Huang
 * 
 */
public interface IUserDao {
	/**
	 * 根据用户名和用户密码查询用户
	 * @param logonName
	 * @param logonPwd
	 * @return User
	 */
	User selectUserByInfo(String logonName, String logonPwd);

	/**
	 * 添加用户
	 * @param user
	 * @return int
	 */
	int addUser(User user);

	/**
	 * 更新用户信息
	 * @param user
	 * @return int 
	 */
	int updateUser(User user);

	/**
	 * 根据用户Id删除用户
	 * @param userID
	 * @return int
	 */
	int deleteUser(Integer userID);

	/**
	 * 根据用户Id查询用户
	 * @param userID
	 * @return User
	 */
	User selectUserById(Integer userID);

	/**
	 * 查询所有用户信息
	 * @return List
	 */
	List<User> selectAllUser();

	/**
	 * 根据指定条件获取用户信息
	 * 当条件是null的时候忽略条件
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return List
	 */
	List<User> selectUserByCondition(String userName, String gender,
			String education, String isUpload);

}
