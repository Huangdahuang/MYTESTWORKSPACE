package com.itheima.dao;

import java.sql.SQLException;

import com.itheima.domain.Account;

public interface AccountDao {
	/**
	 * ת��
	 * 
	 * @param fromname
	 *            ת���û�
	 * @param toname
	 *            ת���û�
	 * @param money
	 *            ת�˽��
	 * @throws SQLException
	 */
	@Deprecated
	public void updateAccoount(String fromname, String toname, double money)
			throws Exception;

	/**
	 * �����˻���Ϣ�޸Ľ��
	 * 
	 * @param account
	 */
	public void updateAccount(Account account) throws Exception;

	/**
	 * ���� �û��� name�����˻���Ϣ
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Account findAccountByName(String name) throws Exception;
}
