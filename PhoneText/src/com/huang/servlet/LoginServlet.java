package com.huang.servlet;

import java.io.IOException;
import java.io.RandomAccessFile;

public class LoginServlet {
	private String username ;
	private String password;
	
	public LoginServlet(String username ,String password){
		this.password = password;
		this.username = username;
	}
	
	public boolean login(){
		try (RandomAccessFile raf = new RandomAccessFile("./conf/user.dat", "r");) {
			for (int i = 0; i < raf.length() / 100; i++) {
				raf.seek(100 * i);
				byte[] data = new byte[32];
				// ¶ÁÈ¡username
				raf.read(data);
				String name = new String(data, "UTF-8").trim();
				if (name.equals(username)) {
					raf.read(data);
					String pwd = new String(data, "UTF-8").trim();
					if (pwd.equals(password)) {
						return true;
					}
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
