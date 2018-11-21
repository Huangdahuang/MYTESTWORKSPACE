package com.itheima.web.action;
/**
 * 演示配置文件的加载顺序
 * @author Administrator
 *
 */
public class Demo1Action {
	public String sayHello() {
		System.out.println("方法执行了");
		return "success";
	}
}
