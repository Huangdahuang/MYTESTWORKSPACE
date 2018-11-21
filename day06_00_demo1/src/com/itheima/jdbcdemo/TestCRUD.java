package com.itheima.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.itheima.entity.User;

public class TestCRUD {

	@Test
	public void TestSelect() throws Exception {
		// 1����������(��������)
		Class.forName("com.mysql.jdbc.Driver");
		// 2����������
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/day06", "root", "root");
		// 3���õ�ִ��sql����Statement����
		Statement stmt = conn.createStatement();
		// 4��ִ��sql��䣬�����ؽ��
		ResultSet rs = stmt.executeQuery("select * from users");
		List<User> list = new ArrayList<User>();
		
		// 5��������
		User u = new User();
		while (rs.next()) {
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setBirthday(rs.getDate("birthday"));
			list.add(u);
		}
		// 6�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
		
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testInsert() throws Exception {
		// 1����������
		Class.forName("com.mysql.jdbc.Driver");
		// 2����������
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=root");

		// 3���õ�ִ��sql����Statement����
		Statement stmt = conn.createStatement();

		// 4��ִ��sql��䣬�����ؽ��
		int i = stmt
				.executeUpdate("INSERT INTO users VALUES (4,'tom','123','tom@163.com','2015-09-28')");
		if (i > 0) {
			System.out.println("success");
		}

		// 6�ر���Դ
		stmt.close();
		conn.close();
	}

	@Test
	public void testUpdate() throws Exception {
		// 1����������
		Class.forName("com.mysql.jdbc.Driver");
		// 2����������
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=root");

		// 3���õ�ִ��sql����Statement����
		Statement stmt = conn.createStatement();

		// 4��ִ��sql��䣬�����ؽ��
		int i = stmt
				.executeUpdate("UPDATE users SET NAME='jerry',PASSWORD='333',email='jerry@163.com' WHERE id=4");
		if (i > 0) {
			System.out.println("success");
		}

		// 6�ر���Դ
		stmt.close();
		conn.close();
	}

	@Test
	public void testDelete() throws Exception {
		// 1����������
		Class.forName("com.mysql.jdbc.Driver");
		// 2����������
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=root");

		// 3���õ�ִ��sql����Statement����
		Statement stmt = conn.createStatement();

		// 4��ִ��sql��䣬�����ؽ��
		int i = stmt.executeUpdate("DELETE FROM users WHERE id=4");
		if (i > 0) {
			System.out.println("success");
		}

		// 6�ر���Դ
		stmt.close();
		conn.close();
	}

}
