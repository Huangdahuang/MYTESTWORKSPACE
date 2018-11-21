package com.itheima.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccoutDaoImpl;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import com.itheima.util.C3P0Util;

public class AccountServiceImpl implements AccountService {

	public void transfer(String fromname, String toname, double money) {
		// ad.updateAccoount(fromname, toname, money);

		Connection conn = C3P0Util.getConnection();
		AccountDao ad = new AccoutDaoImpl(conn);
		try {
			conn.setAutoCommit(false);// begin执行
			// 分别得到转出和传入账户
			Account fromAccount = ad.findAccountByName(fromname);
			Account toAccount = ad.findAccountByName(toname);

			// 修改账户的金额
			fromAccount.setMoney(fromAccount.getMoney() - money);
			toAccount.setMoney(toAccount.getMoney() + money);

			// 完成转账操作
			ad.updateAccount(fromAccount);
			ad.updateAccount(toAccount);

			conn.commit();// 提交事务
		} catch (Exception e) {
			try {
				conn.rollback();// 回滚事物
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
