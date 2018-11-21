package com.itheima;

import javax.xml.crypto.dsig.keyinfo.KeyName;

public class TestClassLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassLoader c1 = KeyName.class.getClassLoader();
		System.out.println(c1);
	}

}
