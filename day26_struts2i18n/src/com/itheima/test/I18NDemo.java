package com.itheima.test;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

/**
 * ���ʻ��Ĳ���
 * @author Zhihong_Huang
 * 
 */
public class I18NDemo {
	@Test
	public void test1() {
		ResourceBundle bundle = ResourceBundle.getBundle("com.itheima.resources.message",Locale.CHINA);
		String value = bundle.getString("key");
		System.out.println(value);
	}
}
