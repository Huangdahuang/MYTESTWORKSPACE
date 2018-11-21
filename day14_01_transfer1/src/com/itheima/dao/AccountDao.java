package com.itheima.dao;

import java.sql.SQLException;

import com.itheima.domain.Account;

public interface AccountDao {
	/**
	 * 转账
	 * 
	 * @param fromname
	 *            转出用户
	 * @param toname
	 *            转入用户
	 * @param money
	 *            转账金额
	 * @throws SQLException
	 */
	@Deprecated
	public void updateAccoount(String fromname, String toname, double money)
			throws Exception;

	/**
	 * 根据账户信息修改金额
	 * 
	 * @param account
	 */
	public void updateAccount(Account account) throws Exception;

	/**
	 * 根据 用户名 name查找账户信息
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Account findAccountByName(String name) throws Exception;
}
