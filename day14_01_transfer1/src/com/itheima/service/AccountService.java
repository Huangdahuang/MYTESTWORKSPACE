package com.itheima.service;

import java.sql.SQLException;

public interface AccountService {
	/**
	 * ת��
	 * @param fromname ת���û�
	 * @param toname ת���û�
	 * @param money ת�˽��
	 * @throws SQLException 
	 */
	public void transfer(String fromname,String toname,double money);
}
