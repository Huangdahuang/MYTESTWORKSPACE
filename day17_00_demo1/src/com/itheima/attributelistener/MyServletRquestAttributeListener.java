package com.itheima.attributelistener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRquestAttributeListener implements
		ServletRequestAttributeListener {

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequest�������");

	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequest�Ƴ�����");
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequest�滻����");
		System.out.println("�滻����"+srae.getName());

	}

}
