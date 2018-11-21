package com.itheima.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//使用JDBC技术实现查询数据库数据并显示在控制台中
public class Demo1 {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//1、注册驱动(基本不用)
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// 2、创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "root");
		// 3、得到执行sql语句的Statement对象
		Statement stmt = conn.createStatement();
		// 4、执行sql语句，并返回结果
		ResultSet rs= stmt.executeQuery("select * from users");
		// 5、处理结果
		while (rs.next()) {
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));//将12345改名为列名
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("=============");
		}
		// 6关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}

}
