package com.itheima.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtils {
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		ResourceBundle rd = ResourceBundle.getBundle("dbinfo");
		//¸³Öµ
		driverClass = rd.getString("driverClass");
		url = rd.getString("url");
		user = rd.getString("user");
		password = rd.getString("password");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//Á´½Ó
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(url, user, password);
	}
	
	//¹Ø±Õ
	public static void closeAll(ResultSet rs,Statement stmt,Connection conn) {
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs=null;
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt=null;
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn=null;
		}
	}
		
}














