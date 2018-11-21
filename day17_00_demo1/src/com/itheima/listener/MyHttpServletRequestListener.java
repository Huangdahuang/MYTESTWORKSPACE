package com.itheima.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyHttpServletRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("ServletRequest������");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("ServletRequest������");
	}

}
