package com.itheima.b_factory_bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("ǰ3");
		Object obj = mi.proceed();
		System.out.println("��3");
		return obj;
	}

}
