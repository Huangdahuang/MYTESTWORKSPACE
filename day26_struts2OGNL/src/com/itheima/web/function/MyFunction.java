package com.itheima.web.function;

/**
 * EL表达式的自定义方法，只能支持静态方法调用
 * 1编写一个静态方法实现方法，
 * 2配置方法，在web-inf目录中创建一个扩展名为.tld的xml文件，文件不能方法classes和lib目录下
 * 3在jsp页面中使用taglib指令引入外部的标签库 
 * @author Zhihong_Huang
 *
 */
public class MyFunction {
	public static String toUpperCase(String str) {
		return str.toUpperCase();
	}
}
