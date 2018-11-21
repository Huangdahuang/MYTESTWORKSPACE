package com.itheima.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Hibernate工具类
 * 
 * @author Zhihong_Huang
 * @return Session
 */
public class H3Utils {

	private static SessionFactory sf;

	static {
		// 1：读取配置文件hibernate.cfg.xml
		Configuration conf = new Configuration().configure();
		// 2：根据配置创建SessionFactory
		sf = conf.buildSessionFactory();
		// 关闭虚拟机时，释放SessionFactory
		//服务器当中
		/*Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("虚拟机关闭！释放资源");
				sf.close();
			}
		}));*/
	}

	/**
	 * 获得Session
	 * 
	 * @return
	 */
	public static Session openSession() {
		Session session = sf.openSession();
		return session;
	}

	/**
	 * 获得与当前线程绑定的Session
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
