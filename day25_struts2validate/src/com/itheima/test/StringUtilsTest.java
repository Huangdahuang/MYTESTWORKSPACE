package com.itheima.test;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {

	public static void main(String[] args) {
		String s1 = null;
		String s2 = "";
		String s3 = "     ";
		//isEmpty验证字符串是否为null，或者是空字符串。但是不去空格
		System.out.println(StringUtils.isEmpty(s1));
		System.out.println(StringUtils.isEmpty(s2));
		System.out.println(StringUtils.isEmpty(s3));
		System.out.println("----------------------");
		//isBlank验证字符串是否为null,或者是空字符串。但是去空格
		System.out.println(StringUtils.isBlank(s1));
		System.out.println(StringUtils.isBlank(s2));
		System.out.println(StringUtils.isBlank(s3));
	}

}
