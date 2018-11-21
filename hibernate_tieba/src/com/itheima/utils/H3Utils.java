package com.itheima.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Hibernate������
 * 
 * @author Zhihong_Huang
 * @return Session
 */
public class H3Utils {

	private static SessionFactory sf;

	static {
		// 1����ȡ�����ļ�hibernate.cfg.xml
		Configuration conf = new Configuration().configure();
		// 2���������ô���SessionFactory
		sf = conf.buildSessionFactory();
		// �ر������ʱ���ͷ�SessionFactory
		//����������
		/*Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("������رգ��ͷ���Դ");
				sf.close();
			}
		}));*/
	}

	/**
	 * ���Session
	 * 
	 * @return
	 */
	public static Session openSession() {
		Session session = sf.openSession();
		return session;
	}

	/**
	 * ����뵱ǰ�̰߳󶨵�Session
	 * 
	 * @return 
	 */
	public static Session getCurrentSession() {
		Session session = sf.getCurrentSession();
		return session;
	}
	
	public static void main(String[] args) {
		getCurrentSession();
	}
}
