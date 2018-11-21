package com.itheima.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	// �õ�һ������Դ
	private static DataSource dataSource = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return dataSource;
	}

	// �õ�һ��connection����
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("��������æ������");
		}
	}

	// �ͷ���Դ
	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();// �ر�
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
