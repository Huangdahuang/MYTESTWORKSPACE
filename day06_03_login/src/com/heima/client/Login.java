package com.heima.client;

import java.util.Scanner;

import com.heima.service.DoLogin;
import com.itheima.entity.User;

public class Login {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("������û�����");
		String name = input.nextLine();
		System.out.println("����������");
		String password = input.nextLine();
		
		DoLogin d1 = new DoLogin();
		User user = d1.findUser(name, password);
		if(user != null) {
			System.out.println("Wellcome " + user.getName());
		}else{
			System.out.println("ERROS");
		}
	}
}
