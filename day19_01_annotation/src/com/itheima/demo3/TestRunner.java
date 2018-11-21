package com.itheima.demo3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //查看测试类中的方法哪个有注解@MyTest就运行哪个方法
		
//		test1();
		
		Class clazz = SomeDaoImpl.class;
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			//得到当前方法上的注解对象
			MyTest myTest = m.getAnnotation(MyTest.class);
			if(myTest != null) {
				long timeout = myTest.timeout();
				if(timeout < 0) {
					m.invoke(clazz.newInstance(), null);
				}else {
					long startTime = System.nanoTime();//得到纳秒
					m.invoke(clazz.newInstance(), null);
					long endTime = System.nanoTime();
					if(endTime - startTime > timeout) {
						System.out.println(m.getName() + "超时");
					}
				}
			}
			
			/*if(myTest == null) {//如果没有注解,就不测试执行时间
				m.invoke(clazz.newInstance(), null);
			}else {
				long timeout = myTest.timeout();//得到注解的属性值
				long startTime = System.nanoTime();//得到纳秒
				m.invoke(clazz.newInstance(), null);
				long endTime = System.nanoTime();
				if(endTime - startTime > timeout) {
					System.out.println(m.getName() + "超时");
				}
			}*/
			
		}
	}

	private static void test1() throws IllegalAccessException,
			InvocationTargetException, InstantiationException {
		//得到要执行的类的Class
		Class clazz = SomeDaoImpl.class;
		//得到当前类中的方法,包括本类中和父类中的所有公共方法
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			//判断当前方法上是否有@MyTest注解
			boolean isExistAnno = m.isAnnotationPresent(MyTest.class);
//			System.out.println(m.getName()+"当前方法是否有注解："+isExistAnno);
			if(m.isAnnotationPresent(MyTest.class)) {
				
				m.invoke(clazz.newInstance(), null);
				
			}
		}
	}

}
