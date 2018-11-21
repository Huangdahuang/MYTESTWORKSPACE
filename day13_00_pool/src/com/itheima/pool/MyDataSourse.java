package com.itheima.pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;

import javax.sql.DataSource;

import com.heima.util.DBUtils;

public class MyDataSourse implements DataSource {
	// ����һ�����ӵĳ���
	private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections
			.synchronizedList(new LinkedList<Connection>());

	static {
		try {
			for (int i = 0; i < 10; i++) {
				Connection conn = DBUtils.getConnection();
				pool.add(conn);
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError("��ʼ�����ݿ�����ʧ�ܣ����������ļ��Ƿ���ȷ");
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		if (pool.size() > 0) {
			conn = pool.removeFirst();// �ӳ�����ȥ��һ������
			return conn;
		} else {
			// �ȴ�������
			// �´���һ���µĶ�����
			throw new RuntimeException("��������æ������");
		}
	}
	
	

	public Connection getConnection(String username, String password)
			throws SQLException {

		return null;
	}

	public PrintWriter getLogWriter() throws SQLException {

		return null;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
	}

	public void setLoginTimeout(int seconds) throws SQLException {
	}

	public int getLoginTimeout() throws SQLException {

		return 0;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {

		return null;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {

		return false;
	}

}
