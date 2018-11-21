package com.itheima.b_api;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestApi {
	
	public static void main(String[] args) {
		
		//1 ��������Դ�����ӳأ� dbcp
		BasicDataSource dataSource = new BasicDataSource();
		// * ��������
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_day02");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		
		//2  ����ģ��
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		
		//3 ͨ��api����
		jdbcTemplate.update("insert into t_user(username,password) values(?,?);", "tom","998");
		
	}

}
