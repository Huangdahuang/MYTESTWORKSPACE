package com.itheima.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
       System.out.println("ServletContext�����ʼ����");	
	}

	public void contextDestroyed(ServletContextEvent sce) {
	   System.out.println("ServletContext����������");
	}

}
