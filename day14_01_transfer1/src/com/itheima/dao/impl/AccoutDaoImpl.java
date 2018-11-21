package com.itheima.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.util.C3P0Util;

public class AccoutDaoImpl implements AccountDao {

	private Connection conn;

	public AccoutDaoImpl(Connection conn) {
		this.conn = conn;
	}

	public void updateAccoount(String fromname, String toname, double money)
			throws Exception {
		// ����һ��QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		qr.update("update account set money = money - ? where name = ?", money,
				fromname);
		qr.update("update account set money = money + ? where name = ?", money,
				toname);
	}

	public void updateAccount(Account account) throws Exception {
		QueryRunner qr = new QueryRunner();
		qr.update(C3P0Util.getConnection(),
				"update account set money = ? where name = ?",
				account.getMoney(), account.getName());
	}

	public Account findAccountByName(String name) throws Exception {
		QueryRunner qr = new QueryRunner();
		return qr.query(C3P0Util.getConnection(),
				"select * from account where name = ?",
				new BeanHandler<Account>(Account.class), name);

	}

}
