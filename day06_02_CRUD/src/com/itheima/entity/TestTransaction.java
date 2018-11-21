package com.itheima.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.heima.util.DBUtils;

public class TestTransaction {
	@Test
	public void test1() {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtils.getConnection();
			conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			conn.setAutoCommit(false);//�൱��begin��������
			ps = conn.prepareStatement("UPDATE account SET money=money-100 WHERE NAME='aaa'");
			ps.executeUpdate();
			//int i = 10 / 0;
			ps = conn.prepareStatement("UPDATE account SET money=money+100 WHERE NAME='bbb'");
			ps.executeUpdate();
			
			conn.commit();//�ύ���� commit
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}//�ع�����
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
	}
}
