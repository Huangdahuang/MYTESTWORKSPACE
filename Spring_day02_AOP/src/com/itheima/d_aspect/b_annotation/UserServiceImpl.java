package com.itheima.d_aspect.b_annotation;

import org.springframework.stereotype.Service;

@Service("userServiceId")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("d_aspect.b_annotation addUser");
	}

	@Override
	public String updateUser() {
		System.out.println("d_aspect.b_annotation updateUser");
		//int i = 1 / 0;
		return "yangshish";
	}

	@Override
	public void deleteUser() {
		System.out.println("d_aspect.b_annotation deleteUser");
	}

}
