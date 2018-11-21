package com.itheima.d_aspect.b_annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * 切面类，含有多个通知
 * 
 * @author Zhihong_Huang
 * 
 */
@Component("myAspectId")
public class MyAspect {
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("前置通知:" + joinPoint.getSignature().getName());
	}

	public void myAfterReturning(JoinPoint joinPoint, Object ret) {
		System.out.println("后置通知:" + joinPoint.getSignature().getName() + "-->"
				+ ret);
	}

	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("前");
		Object obj = joinPoint.proceed();
		System.out.println("后");
		return obj;
	}
	
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e) {
		System.out.println("抛异常通知" + e.getMessage());
	}
	
	public void myAfter(JoinPoint joinPoint) {
		System.out.println("后通知:" + joinPoint.getSignature().getName());
	}
}
