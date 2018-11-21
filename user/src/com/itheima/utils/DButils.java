package com.itheima.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DButils {
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	static { // 加载初始化
		ResourceBundle rb = ResourceBundle.getBundle("dbinfo");//专门加载属性资源文件
		driverClass=rb.getString(driverClass);
		url=rb.getString(url);
		username=rb.getString(username);
		password=rb.getString(password);
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//得到链接
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(url, username, password);
	}
	//关闭资源
	public static void closeAll(ResultSet rs,Statement stmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs= null;
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt= null;
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn= null;
		}
	}
}
