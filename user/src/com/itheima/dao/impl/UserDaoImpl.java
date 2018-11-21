package com.itheima.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.DButils;

public class UserDaoImpl implements UserDao {

	public void addUser(User user) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DButils.getConnection();
			ps = conn
					.prepareStatement("INSERT INTO users(username,PASSWORD,email,birthday) VALUE (?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(user.getBirthday());
			ps.setString(4, date);
			
			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("ÃÌº” ß∞‹");
		}finally{
			DButils.closeAll(null,ps,conn);
		}

	}

	public User findUser(User user) throws Exception {

		return null;
	}

}
