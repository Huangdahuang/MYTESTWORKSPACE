package com.itheima.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class XMQ {
	public static void main(String[] args) {
//		PJL pjl = new PJL(); 
		final KindWomen wp = new YPX();//真实对象
		
//		KindWomen wp = new WP(pjl);
		//KindWomen wp = new WP(ypx);//代理对象
		
		KindWomen proxy = (KindWomen) Proxy.newProxyInstance(wp.getClass().getClassLoader(), wp.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				return method.invoke(wp, null);
			}
		});
		
		proxy.throwEye();
		proxy.doSomeThing();
	}
}
