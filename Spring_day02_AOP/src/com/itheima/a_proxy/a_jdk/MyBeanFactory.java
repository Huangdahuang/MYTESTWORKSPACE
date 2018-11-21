package com.itheima.a_proxy.a_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {
	public static UserService createService() {
		//1 ��Ŀ����
		final UserService userService  = new UserServiceImpl();
		//2:������
		final MyAspect myAspect = new MyAspect();
		//3:������-->��Ŀ���ࣨ����㣩�������֪ࣨͨ�����-->����
		
		UserService proxyService = (UserService) Proxy.newProxyInstance(
				MyBeanFactory.class.getClassLoader(), 
				 userService.getClass().getInterfaces(), 
				 new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						// ǰִ��
						myAspect.before();
						// ִ��Ŀ����ķ���
						Object obj = method.invoke(userService, args);
						// ��ִ��
						myAspect.after();
						return obj;
					}
				});
		
		return proxyService;
	}
}























