package com.itheima.c_spring_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("Ç°4");
		Object obj = mi.proceed();
		System.out.println("ºó4");
		return obj;
	}

}
