package com.itheima.a_proxy.b_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {
	public static UserServiceImpl createService() {
		// 1 ��Ŀ����
		final UserServiceImpl userService = new UserServiceImpl();
		// 2:������
		final MyAspect myAspect = new MyAspect();
		// 3:������-->��Ŀ���ࣨ����㣩�������֪ࣨͨ�����-->����
		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(userService.getClass());

		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object proxyy, Method method,
					Object[] args, MethodProxy methodProxy) throws Throwable {
				myAspect.before();
				Object obj = method.invoke(userService, args);
//				methodProxy.invokeSuper(proxyy, args);
				myAspect.after();
				return obj;
			}
		});

		UserServiceImpl proxyService = (UserServiceImpl) enhancer.create();

		return proxyService;
	}
}
