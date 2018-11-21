package com.itheima.www;
/**
 * 
* <p>Title: Demo</p>  
* <p>Description: </p>  
* @author shenlan  
* @date Jun 22, 2018
 */
public class Demo {

	public static void main(String[] args) {
		String s1 = "ABCFGRT";
		String s2 = "RTA";
		int len = s1.length();
		char[] arr = s1.toCharArray();
		for(int i = 0 ; i < len - 1 ; i++) {
			System.out.println(arr[i]);
		}
		//System.out.println(s1.indexOf("RTA"));
	}

}
