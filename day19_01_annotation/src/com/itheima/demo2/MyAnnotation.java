package com.itheima.demo2;

//����һ��ע����
public @interface MyAnnotation {
	// ����
	int age();

	String name();
	
	String sex() default "-1";
	
	String value();
}
