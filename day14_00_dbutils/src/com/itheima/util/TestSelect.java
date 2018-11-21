package com.itheima.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.itheima.entity.User;

public class TestSelect {

	@Test
	public void testSelect() throws SQLException {
		// 创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		// 使用query方法执行select语句
		List<User> list = qr.query("select * from users",
				new ResultSetHandler<List<User>>() {
					// 执行query语句后，是将结果集以参数的形式传递
					public List<User> handle(ResultSet rs) throws SQLException {
						List<User> list = new ArrayList<User>();
						while (rs.next()) {
							User u = new User();
							u.setId(rs.getInt(1));
							u.setName(rs.getString(2));
							u.setPassword(rs.getString(3));
							u.setEmail(rs.getString(4));
							u.setBirthday(rs.getDate(5));
							list.add(u);
						}
						return list;
					}

				});
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testSelect2() throws SQLException {
		// 创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		//执行query查询语句并返回结果
		List<User> list = qr.query("select * from users where id = ?",
				new BeanListHandler<User>(User.class),3);
		for (User user : list) {
			System.out.println(user);
		}
	}
}
