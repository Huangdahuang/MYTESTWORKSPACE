package com.itheima.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;

@Transactional
public class AccountServiceImpl implements AccountService {
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String outer, String inner, Integer money) {
		accountDao.out(outer, money);
		// ¶Ïµç
		int i = 1 / 0;
		accountDao.in(inner, money);

	}

}
