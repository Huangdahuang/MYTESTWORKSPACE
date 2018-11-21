package com.itheima.a_proxy.a_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {
	public static UserService createService() {
		//1 ：目标类
		final UserService userService  = new UserServiceImpl();
		//2:切面类
		final MyAspect myAspect = new MyAspect();
		//3:代理类-->将目标类（切入点）和切面类（通知）结合-->切面
		
		UserService proxyService = (UserService) Proxy.newProxyInstance(
				MyBeanFactory.class.getClassLoader(), 
				 userService.getClass().getInterfaces(), 
				 new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						// 前执行
						myAspect.before();
						// 执行目标类的方法
						Object obj = method.invoke(userService, args);
						// 后执行
						myAspect.after();
						return obj;
					}
				});
		
		return proxyService;
	}
}























