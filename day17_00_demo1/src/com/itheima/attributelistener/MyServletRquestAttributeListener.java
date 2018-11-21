package com.itheima.attributelistener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRquestAttributeListener implements
		ServletRequestAttributeListener {

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequestÌí¼ÓÊôĞÔ");

	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequestÒÆ³ıÊôĞÔ");
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequestÌæ»»ÊôĞÔ");
		System.out.println("Ìæ»»ÊôĞÔ"+srae.getName());

	}

}
