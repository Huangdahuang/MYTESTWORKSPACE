package com.heima.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.heima.util.DBUtils;
import com.itheima.entity.User;

public class testCRUD {
	@Test
	public void testSelect() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from users");
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

			for (User user : list) {
				System.out.println(user);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, conn);
		}
	}
	@Test
	public void testInsert() {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			int i = stmt.executeUpdate("INSERT INTO users VALUES (4,'tom','123','tom@163.com','2015-09-28')");
			if(i > 0) {
				System.out.println("success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, stmt, conn);
		}
	}
	@Test
	public void testUpdate(){
		Connection conn = null;
		Statement stmt = null;
	
		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			int i = stmt.executeUpdate("UPDATE users SET NAME='jerry',PASSWORD='333',email='jerry@qq.com' WHERE id=4");
			if(i>0){
				System.out.println("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, stmt, conn);
		}
	}
	
	@Test
	public void testDelete(){
		Connection conn = null;
		Statement stmt = null;
	
		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			int i = stmt.executeUpdate("DELETE FROM users WHERE id=4");
			if(i>0){
				System.out.println("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, stmt, conn);
		}
	}
}
