package com.itheima.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
       System.out.println("ServletContext对象初始化了");	
	}

	public void contextDestroyed(ServletContextEvent sce) {
	   System.out.println("ServletContext对象销毁了");
	}

}
