package com.itheima.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

//使用JDBC技术实现查询数据库数据并显示在控制台中
public class Demo2 {

	/**
	 * @param args
	 * @throws Exception
	 * @throws Exception
	 */

	@Test
	public void test1() throws Exception {
		// TODO Auto-generated method stub
		// 1、加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2、创建连接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/day06", "root", "root");
		// 3、得到执行sql语句的Statement对象
		Statement stmt = conn.createStatement();
		// 4、执行sql语句，并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		// 5、处理结果
		while (rs.next()) {
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("=============");
		}
		// 6关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}

	@Test
	public void test2() throws Exception {
		// 1、加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2、创建连接
		
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "root");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", info);
		
		// 3、得到执行sql语句的Statement对象
		Statement stmt = conn.createStatement();
		// 4、执行sql语句，并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		// 5、处理结果0
		while (rs.next()) {
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("=============");
		}
		// 6关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}
	
	
	@Test
	public void test3() throws Exception {
		// 1、加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2、创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day14?user=root&password=root");
		
		// 3、得到执行sql语句的Statement对象
		Statement stmt = conn.createStatement();
		
		// 4、执行sql语句，并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		
		// 5、处理结果
		while (rs.next()) {
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("=============");
		}
		// 6关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}
	
	
	@Test
	public void test4() throws Exception {
		// TODO Auto-generated method stub
		// 2、创建连接
		Connection conn = null;
		// 3、得到执行sql语句的Statement对象
		Statement stmt = null;
		// 4、执行sql语句，并返回结果
		ResultSet rs = null;
		try {
			// 1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/day06", "root", "root");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from users");
			// 5、处理结果
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
			// 6关闭资源
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
