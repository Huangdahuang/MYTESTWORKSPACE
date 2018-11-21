package com.itheima.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

//ʹ��JDBC����ʵ�ֲ�ѯ���ݿ����ݲ���ʾ�ڿ���̨��
public class Demo2 {

	/**
	 * @param args
	 * @throws Exception
	 * @throws Exception
	 */

	@Test
	public void test1() throws Exception {
		// TODO Auto-generated method stub
		// 1����������
		Class.forName("com.mysql.jdbc.Driver");
		// 2����������
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/day06", "root", "root");
		// 3���õ�ִ��sql����Statement����
		Statement stmt = conn.createStatement();
		// 4��ִ��sql��䣬�����ؽ��
		ResultSet rs = stmt.executeQuery("select * from users");
		// 5��������
		while (rs.next()) {
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("=============");
		}
		// 6�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
	}

	@Test
	public void test2() throws Exception {
		// 1����������
		Class.forName("com.mysql.jdbc.Driver");
		// 2����������
		
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "root");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", info);
		
		// 3���õ�ִ��sql����Statement����
		Statement stmt = conn.createStatement();
		// 4��ִ��sql��䣬�����ؽ��
		ResultSet rs = stmt.executeQuery("select * from users");
		// 5��������0
		while (rs.next()) {
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("=============");
		}
		// 6�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
	}
	
	
	@Test
	public void test3() throws Exception {
		// 1����������
		Class.forName("com.mysql.jdbc.Driver");
		// 2����������
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day14?user=root&password=root");
		
		// 3���õ�ִ��sql����Statement����
		Statement stmt = conn.createStatement();
		
		// 4��ִ��sql��䣬�����ؽ��
		ResultSet rs = stmt.executeQuery("select * from users");
		
		// 5��������
		while (rs.next()) {
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("=============");
		}
		// 6�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
	}
	
	
	@Test
	public void test4() throws Exception {
		// TODO Auto-generated method stub
		// 2����������
		Connection conn = null;
		// 3���õ�ִ��sql����Statement����
		Statement stmt = null;
		// 4��ִ��sql��䣬�����ؽ��
		ResultSet rs = null;
		try {
			// 1����������
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/day06", "root", "root");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from users");
			// 5��������
			while (rs.next()) {
				System.out.println(rs.getObject(1));
				System.out.println(rs.getObject(2));
				System.out.println(rs.getObject(3));
				System.out.println(rs.getObject(4));
				System.out.println(rs.getObject(5));
				System.out.println("=============");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			// 6�ر���Դ
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs = null;
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				stmt = null;
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				conn = null;
			}
		}
	}

}
