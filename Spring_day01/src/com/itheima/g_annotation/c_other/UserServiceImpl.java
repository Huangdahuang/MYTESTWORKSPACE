package com.itheima.g_annotation.c_other;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("userServiceId")
// @Scope("prototype")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("d_scope add user");
	}

	@PostConstruct
	public void myInit() {
		System.out.println("鍒濆鍖�");
	}

	@PreDestroy
	public void myDestroy() {
		System.out.println("閿�瘉");
	}

}
