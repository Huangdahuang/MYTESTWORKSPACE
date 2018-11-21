package com.itheima.service;

import java.util.List;

import com.itheima.domain.User;

/**
 * 用户操作的相关业务接口
 * 
 * @author Zhihong_Huang
 * 
 */
public interface IUserService {
	/**
	 * 用户登录
	 * 
	 * @param logonName
	 * @param logonPwd
	 * @return User
	 */
	User login(String logonName, String logonPwd);

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return int
	 */
	int saveUser(User user);

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return int
	 */
	int modifyUser(User user);

	/**
	 * 根据用户id删除用户
	 * 
	 * @param userID
	 * @return int
	 */
	int removeUser(Integer userID);

	/**
	 * 根据用户id，获取用户信息
	 * 
	 * @param userID
	 * @return User
	 */
	User findUserByID(Integer userID);

	/**
	 * 查询所有用户
	 * 
	 * @return List<User>
	 */
	List<User> findAllUser();

	/**
	 * 根据条件查找
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
