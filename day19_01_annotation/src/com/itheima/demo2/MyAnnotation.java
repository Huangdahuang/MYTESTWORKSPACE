package com.itheima.demo2;

//创建一个注解类
public @interface MyAnnotation {
	// 属性
	int age();

	String name();
	
	String sex() default "-1";
	
	String value();
}
