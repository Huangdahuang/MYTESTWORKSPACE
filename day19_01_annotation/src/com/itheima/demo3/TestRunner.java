package com.itheima.demo3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //�鿴�������еķ����ĸ���ע��@MyTest�������ĸ�����
		
//		test1();
		
		Class clazz = SomeDaoImpl.class;
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			//�õ���ǰ�����ϵ�ע�����
			MyTest myTest = m.getAnnotation(MyTest.class);
			if(myTest != null) {
				long timeout = myTest.timeout();
				if(timeout < 0) {
					m.invoke(clazz.newInstance(), null);
				}else {
					long startTime = System.nanoTime();//�õ�����
					m.invoke(clazz.newInstance(), null);
					long endTime = System.nanoTime();
					if(endTime - startTime > timeout) {
						System.out.println(m.getName() + "��ʱ");
					}
				}
			}
			
			/*if(myTest == null) {//���û��ע��,�Ͳ�����ִ��ʱ��
				m.invoke(clazz.newInstance(), null);
			}else {
				long timeout = myTest.timeout();//�õ�ע�������ֵ
				long startTime = System.nanoTime();//�õ�����
				m.invoke(clazz.newInstance(), null);
				long endTime = System.nanoTime();
				if(endTime - startTime > timeout) {
					System.out.println(m.getName() + "��ʱ");
				}
			}*/
			
		}
	}

	private static void test1() throws IllegalAccessException,
			InvocationTargetException, InstantiationException {
		//�õ�Ҫִ�е����Class
		Class clazz = SomeDaoImpl.class;
		//�õ���ǰ���еķ���,���������к͸����е����й�������
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			//�жϵ�ǰ�������Ƿ���@MyTestע��
			boolean isExistAnno = m.isAnnotationPresent(MyTest.class);
//			System.out.println(m.getName()+"��ǰ�����Ƿ���ע�⣺"+isExistAnno);
			if(m.isAnnotationPresent(MyTest.class)) {
				
				m.invoke(clazz.newInstance(), null);
				
			}
		}
	}

}
