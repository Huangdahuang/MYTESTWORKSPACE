package com.itheima.util;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

public class TestCRUD {
	@Test
	public void testInsert() throws SQLException {
		// ����һ��QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		// ִ��sql���
		qr.update(
				"insert into users(name,password,email,birthday) values(?,?,?,?)",
				"��10", "123", "c10@163.com", new Date());
	}
	
	@Test
	public void testUpdata() throws SQLException {
		// ����һ��QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		// ִ��sql���
		qr.update("update users set name=?,password=? where id=?", "�ܽܽ�","333",4);
	}
	
	@Test
	public void testDelete() throws SQLException{
		//����һ��QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from users where id=?", 4);
	}
	
	@Test//������ֻ��ִ����ͬ��sql���
	public void testBatch() throws SQLException{
		//����һ��QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		Object[][] params = new Object[10][];//��ά����ִ�ж��ٴ�sql���
		for (int i = 0; i < params.length; i++) {//ѭ��10��
			params[i] = new Object[]{"��10"+i,"123","c10@163.com",new Date()};//��ÿ��ִ�е�sql����еģ���ֵ
		}
		qr.batch("insert into users(name,password,email,birthday) values(?,?,?,?)", params );
		
	}
	
}
