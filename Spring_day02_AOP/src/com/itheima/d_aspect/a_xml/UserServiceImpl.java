package com.itheima.d_aspect.a_xml;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("d_aspect.a_xml addUser");
	}

	@Override
	public String updateUser() {
		System.out.println("d_aspect.a_xml updateUser");
		int i = 1 / 0;
		return "yangshish";
	}

	@Override
	public void deleteUser() {
		System.out.println("d_aspect.a_xml deleteUser");
	}

}
