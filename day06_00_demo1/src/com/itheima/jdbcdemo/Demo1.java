package com.itheima.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//ʹ��JDBC����ʵ�ֲ�ѯ���ݿ����ݲ���ʾ�ڿ���̨��
public class Demo1 {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//1��ע������(��������)
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// 2����������
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "root");
		// 3���õ�ִ��sql����Statement����
		Statement stmt = conn.createStatement();
		// 4��ִ��sql��䣬�����ؽ��
		ResultSet rs= stmt.executeQuery("select * from users");
		// 5��������
		while (rs.next()) {
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));//��12345����Ϊ����
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("=============");
		}
		// 6�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
	}

}
