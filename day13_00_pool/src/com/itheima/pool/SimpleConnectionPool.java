package com.itheima.pool;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;

import com.heima.util.DBUtils;

//模拟数据库连接池，但不具备实际开发意义
public class SimpleConnectionPool {
	// 创建一个连接的池子
	private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections
			.synchronizedList(new LinkedList<Connection>());

	static {
		try {
			for (int i = 0; i < 10; i++) {
				Connection conn = DBUtils.getConnection();
				pool.add(conn);
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError("初始化数据库连接失败，请检查配置文件是否正确");
		}
	}

	// 得到一个连接
	public Connection getConnectionFromPool() {
		Connection conn = null;
		if (pool.size() > 0) {
			conn = pool.removeFirst();// 从池子中去除一个连接
			return conn;
		}else {
			//等待。。。
		    //新创建一个新的额连接
			throw new RuntimeException("服务器繁忙。。。");
		}
	}

	// 释放资源
	public void release(Connection conn) {
		pool.addLast(conn);
	}

}
