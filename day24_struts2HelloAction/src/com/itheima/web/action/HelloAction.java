package com.itheima.web.action;
/**
 * Struts2的入门案例
 * @author Zhihong-Huang
 *
 */
public class HelloAction {//动作类
	/**
	 * 在动作类中的指定的动作方法
	 * 动作方法的书写要求
	 * 	    1：都是public
	 *      2:返回值必须是String 
	 *      3:必须没有参数
	 * @return
	 */
	public String sayHello() {
		System.out.println("HelloAction的sayHello方法执行了");
		return "success";//与配置文件struts.xml中的result中的name值对应
	}
}
